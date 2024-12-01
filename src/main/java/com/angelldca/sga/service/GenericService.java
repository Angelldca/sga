package com.angelldca.sga.service;


import com.angelldca.sga.Entity.Evento;
import com.angelldca.sga.Entity.Medida;
import com.angelldca.sga.exceptions.SigaAppExceptions;
import com.angelldca.sga.repository.IRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class GenericService <T,ID>{
    private final IRepository<T, ID> modelRepository;

    public GenericService(IRepository<T, ID> modelRepository) {
        this.modelRepository = modelRepository;
    }

    public T findById(ID id){
        Optional<T> model = modelRepository.findById(id);
        if(!model.isPresent()){
            throw new SigaAppExceptions("El elemento no existe",HttpStatus.NOT_FOUND);
        }
        return model.get();
    }
    public T create(T t){
        return modelRepository.save(t);
    }
    public List<T> findAll(){
        return modelRepository.findAll();
    }
    public void delete(ID id){
        Optional<T> modelExist = modelRepository.findById(id);
        if (!modelExist.isPresent()) {
            throw new SigaAppExceptions(" El elemento no se encuentra", HttpStatus.BAD_REQUEST);
        }
        modelRepository.deleteById(id);
    }

    public IRepository<T, ID> getModelRepository() {
        return modelRepository;
    }
}
