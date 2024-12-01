package com.angelldca.sga.Entity;


import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalTime;


@Data
@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(unique = true, nullable = false)
    String name;
    boolean activo = false;
    @Column(name = "hora_inicio", nullable = false)
    @NotNull(message = "La hora de inicio no puede ser nula")
    private LocalTime horaInicio;
    @Column(name = "hora_fin", nullable = false)
    @NotNull(message = "La hora de fin no puede ser nula")
    private LocalTime horaFin;
}
