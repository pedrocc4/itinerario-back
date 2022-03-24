package com.bosonit.backend.persona.infrastructure.controller.dto.input;

import com.bosonit.backend.persona.domain.Persona;

import java.util.Date;

public record PersonaInputDTO(
        String usuario,
        String password,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        Boolean active,
        Date created_date,
        String imagen_url,
        Date termination_date,
        Persona.TipoPersona tipoPersona
) {
}
