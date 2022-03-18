package com.bosonit.backend.estudiante.domain;

import com.bosonit.backend.asignatura.domain.Asignatura;
import com.bosonit.backend.persona.domain.Persona;
import com.bosonit.backend.utils.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generador")
    @GenericGenerator(
            name = "generador",
            strategy = "com.bosonit.backend.utils.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_estudiante;

    @NotNull
    private int num_hours_week;

    private String comments;

    private String branch;

    // Relacion con tablas

    @OneToOne(fetch = FetchType.LAZY)
    private Persona id_persona;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }) // sin REMOVE (eliminar asignatura y no estudiantes)
    @JoinTable(
            name = "ESTUDIANTE_ASIGNATURA",
            joinColumns = {@JoinColumn(name = "id_estudiante")},
            inverseJoinColumns = {@JoinColumn(name = "id_asignatura")}
    )
    private Set<Asignatura> asignaturas;

}
