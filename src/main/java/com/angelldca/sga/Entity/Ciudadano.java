package com.angelldca.sga.Entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class Ciudadano {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;
    @NotBlank(message =  "Debe proporcionar un nombre")
    @NotNull(message = "El nombre es requerido")
    private String name;
    @NotBlank(message =  "Debe proporcionar un área")
    @NotNull(message = "El área es requerida")
    private String area;
    @ManyToOne
    @JoinColumn(name = "comedor_id", nullable = false)
    private Comedor comedor;

    @NotBlank(message =  "Debe proporcionar un solapin")
    @NotNull(message = "El solapin es requerido")
    private String solapin;
}
