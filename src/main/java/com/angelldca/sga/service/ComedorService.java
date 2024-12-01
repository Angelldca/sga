package com.angelldca.sga.service;


import com.angelldca.sga.Entity.Comedor;
import com.angelldca.sga.Entity.Plato;
import com.angelldca.sga.exceptions.SigaAppExceptions;
import com.angelldca.sga.repository.ComedorRepository;
import com.angelldca.sga.repository.IRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ComedorService extends GenericService<Comedor,Long>{
    private final ComedorRepository comedorRepository;
    public ComedorService(ComedorRepository comedorRepository) {
        super(comedorRepository);
        this.comedorRepository = comedorRepository;
    }


    @Transactional
    public void update(Comedor comedor){
        Comedor comedorExist = super.findById(comedor.getId());
        comedorExist.setName(comedor.getName());
        comedorExist.setUsuarios(comedor.getUsuarios());
        comedorExist.setCiudadanos(comedor.getCiudadanos());
        super.getModelRepository().save(comedorExist);

    }

    @Override
    public void delete(Long id) {
        Optional<Comedor> comedor = super.getModelRepository().findById(id);
        if(!comedor.isPresent()){
            throw new SigaAppExceptions("El comedor no existe", HttpStatus.NOT_FOUND);
        }

        super.getModelRepository().delete(comedor.get());
    }


}
