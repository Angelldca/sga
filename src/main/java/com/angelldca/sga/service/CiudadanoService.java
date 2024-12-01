package com.angelldca.sga.service;

import com.angelldca.sga.Entity.Ciudadano;
import com.angelldca.sga.Entity.Plato;
import com.angelldca.sga.exceptions.SigaAppExceptions;
import com.angelldca.sga.repository.CiudadanoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;


@Service
public class CiudadanoService extends  GenericService<Ciudadano, UUID>{
   private final CiudadanoRepository ciudadanoRepository;
    public CiudadanoService(CiudadanoRepository ciudadanoRepository) {
        super(ciudadanoRepository);
        this.ciudadanoRepository = ciudadanoRepository;
    }

    @Override
    public void delete(UUID id) {
        Optional<Ciudadano> ciudadano = super.getModelRepository().findById(id);
        if(!ciudadano.isPresent()){
            throw new SigaAppExceptions("El ciudadano no existe", HttpStatus.NOT_FOUND);
        }
        super.getModelRepository().delete(ciudadano.get());
    }
}
