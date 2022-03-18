package com.bosonit.backend.estudiante.service;

import com.bosonit.backend.estudiante.domain.Estudiante;
import com.bosonit.backend.estudiante.infrastructure.controller.dto.EstudianteInputDTO;
import com.bosonit.backend.estudiante.infrastructure.controller.dto.EstudianteOutputDTO;
import com.bosonit.backend.estudiante.infrastructure.controller.dto.EstudiantePersonaOutputDTO;
import com.bosonit.backend.estudiante.infrastructure.controller.mapper.EstudianteMapper;
import com.bosonit.backend.estudiante.repository.EstudianteRepositoryJPA;
import com.bosonit.backend.persona.repository.PersonaRepositoryJPA;
import com.bosonit.backend.utils.exceptions.EstudianteNoEncontrado;
import com.bosonit.backend.utils.exceptions.PersonaNoEncontrada;
import com.bosonit.backend.utils.exceptions.UnprocesableException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepositoryJPA repository;

    @Autowired
    private EstudianteMapper mapper;

    @Autowired
    private PersonaRepositoryJPA personaRepository;

    @Override
    public EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO)
            throws UnprocesableException {
        try {
            //FIXME tiene que haber otra forma
            Estudiante estudiante = mapper.toEntity(estudianteInputDTO);
            estudiante.setId_persona(
                    personaRepository.findById(estudianteInputDTO.getId_persona().getId())
                            .orElseThrow(
                                    () -> new PersonaNoEncontrada(
                                            "Persona con id: "
                                                    + estudianteInputDTO.getId_persona()
                                                    + ", no encontrada")));
            return mapper.toDTO(
                    repository.save(estudiante));
        } catch (ConstraintViolationException c) {
            throw new UnprocesableException(c.getMessage());
        }
    }

    @Override
    public EstudianteOutputDTO getEstudiante(String id)
            throws EstudianteNoEncontrado {
        return mapper.toDTO(repository
                .findById(id)
                .orElseThrow(() -> new EstudianteNoEncontrado
                        ("Estudiante con id: " + id + ", no encontrado")));
    }

    @Override
    public EstudiantePersonaOutputDTO getEstudiante2(String id)
            throws EstudianteNoEncontrado {
        return mapper.toDTO2(repository
                .findById(id)
                .orElseThrow(() -> new EstudianteNoEncontrado
                        ("Estudiante con id: " + id + ", no encontrado")));
    }

    @Override
    public EstudianteOutputDTO actEstudiante(String id, EstudianteInputDTO estudianteInputDTO)
            throws ConstraintViolationException, EstudianteNoEncontrado {
        try {
            Estudiante estudiante =
                    repository
                            .findById(id)
                            .orElseThrow(() ->
                                    new EstudianteNoEncontrado(
                                            "Estudiante con id: " + id + ", no encontrado"));

            // Asignacion de nuevos atributos
            BeanUtils.copyProperties(estudianteInputDTO, estudiante);
            return mapper.toDTO(repository.save(estudiante));
        } catch (ConstraintViolationException e) {
            throw new UnprocesableException(e.getMessage());
        }
    }

    @Override
    public void delEstudiante(String id) {
        repository.delete((repository
                .findById(id)
                .orElseThrow(() -> new EstudianteNoEncontrado
                        ("Estudiante con id: " + id + ", no encontrado"))));
    }

    @Override
    public List<EstudianteOutputDTO> getEstudiantes() {
        return mapper.toDTOList(repository.findAll());
    }
}
