package com.angelldca.sga.Entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Medida {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "El nombre es requerido")
  @Column(unique = true)
  private String name;


}
