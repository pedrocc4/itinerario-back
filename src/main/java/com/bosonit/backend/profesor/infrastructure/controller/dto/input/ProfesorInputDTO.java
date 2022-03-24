package com.bosonit.backend.profesor.infrastructure.controller.dto.input;

import com.bosonit.backend.persona.domain.Persona;
import lombok.Data;

import java.util.List;

public record ProfesorInputDTO(
        String comments,
        String branch,
        List<ProfesorInputDTO> estudiantes,
        Persona id_persona) {
}
