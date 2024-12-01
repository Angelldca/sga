package com.angelldca.sga.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Comedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe proporcionar un nombre al comedor")
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "comedor", cascade = CascadeType.ALL)
    private List<Ciudadano> ciudadanos = new ArrayList<>();

    @OneToMany(mappedBy = "comedor", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonManagedReference
    private List<Usuario> usuarios = new ArrayList<>();
}
