package com.angelldca.sga.Entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Debe proporcionar un nombre para el plato")
    @NotNull(message = "El nombre del plato no puede ser nula")
    private String name;
    private double price = 0;
    @NotNull(message = "La cantidad es requerida")

    private double cantidad;

    @NotNull(message = "La unidad de medida es reuqerida")
    @ManyToOne
    @JoinColumn(name = "medida_id", nullable = false)
    private Medida medida;

    @ManyToMany(mappedBy = "platos")
    private Set<Menu> menus = new HashSet<>();

}
