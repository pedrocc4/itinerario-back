package com.bosonit.backend.persona.repository;

import com.bosonit.backend.persona.domain.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Persona> findPersonasFechaInferior(Persona persona, Date fecha, String orden) {
        List<Persona> personas;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Persona.class);

        Root<Persona> personaRoot = query.from(Persona.class);
        List<Predicate> predicates = new ArrayList<>();

        // Definicion de clausula WHERE

        if (persona.getName() != null) {
            Predicate namePredicate = cb.equal(personaRoot.get("name"), persona.getName());
            predicates.add(namePredicate);
        } else if (persona.getUsuario() != null) {
            Predicate usernamePredicate = cb.equal(personaRoot.get("usuario"), persona.getUsuario());
            predicates.add(usernamePredicate);
        } else if (persona.getSurname() != null) {
            Predicate surnamePredicate = cb.equal(personaRoot.get("surname"), persona.getSurname());
            predicates.add(surnamePredicate);
        }

        Predicate fechaPredicate = cb.lessThan(personaRoot.get("created_date"), fecha);
        predicates.add(fechaPredicate);


        // Definicion de clausula ORDER

        if (orden.equals("name"))
            query.orderBy(cb.asc(personaRoot.get("name")));
        else if (orden.equals("user"))
            query.orderBy(cb.asc(personaRoot.get("usuario")));

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        personas = entityManager.createQuery(query).getResultList();
        return personas;
    }

    @Override
    public List<Persona> findPersonasFechaSuperior(Persona persona, Date fecha, String orden) {
        List<Persona> personas;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Persona.class);

        Root<Persona> personaRoot = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        if (persona.getName() != null) {
            Predicate namePredicate = cb.equal(personaRoot.get("name"), persona.getName());
            predicates.add(namePredicate);
        } else if (persona.getUsuario() != null) {
            Predicate usernamePredicate = cb.equal(personaRoot.get("usuario"), persona.getUsuario());
            predicates.add(usernamePredicate);
        } else if (persona.getSurname() != null) {
            Predicate surnamePredicate = cb.equal(personaRoot.get("surname"), persona.getSurname());
            predicates.add(surnamePredicate);
        }

        Predicate fechaPredicate = cb.greaterThan(personaRoot.get("created_date"), fecha);
        predicates.add(fechaPredicate);

        // Definicion de clausula ORDER

        if (orden.equals("name"))
            query.orderBy(cb.asc(personaRoot.get("name")));
        else if (orden.equals("user"))
            query.orderBy(cb.asc(personaRoot.get("usuario")));

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        personas = entityManager.createQuery(query).getResultList();
        return personas;
    }
}
