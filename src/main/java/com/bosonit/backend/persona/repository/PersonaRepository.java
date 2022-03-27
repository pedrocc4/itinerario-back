package com.bosonit.backend.persona.repository;

import com.bosonit.backend.persona.domain.Persona;
import com.bosonit.backend.persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.Date;
import java.util.List;

public interface PersonaRepository {
    List<Persona> findPersonasFechaSuperior(Persona persona, Date fecha, String orden);
    List<Persona> findPersonasFechaInferior(Persona persona, Date fecha, String orden);
}
