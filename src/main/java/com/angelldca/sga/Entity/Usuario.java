package com.angelldca.sga.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El nombre es requerido")
    private String name;
    @NotNull(message = "El username es requerido")
    private String username;
    @NotNull(message = "La contraseña es requerida")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String pass;



    @ManyToMany
    @JoinTable(
            name = "user_rol",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "comedor_id", nullable = true)
    @JsonBackReference
    private Comedor comedor;
}
