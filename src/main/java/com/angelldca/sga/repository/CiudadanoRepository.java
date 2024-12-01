package com.angelldca.sga.repository;

import com.angelldca.sga.Entity.Ciudadano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CiudadanoRepository extends IRepository<Ciudadano, UUID> {


}
