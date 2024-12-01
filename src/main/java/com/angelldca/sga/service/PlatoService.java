package com.angelldca.sga.service;


import com.angelldca.sga.Entity.Plato;
import com.angelldca.sga.exceptions.SigaAppExceptions;
import com.angelldca.sga.repository.IRepository;
import com.angelldca.sga.repository.PlatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PlatoService extends GenericService<Plato,Long>{
  private final PlatoRepository platoRepository;
    public PlatoService(PlatoRepository platoRepository) {
        super(platoRepository);
        this.platoRepository = platoRepository;
    }
    @Transactional
    public void update(Plato plato){
        Plato platoExist = super.findById(plato.getId());
        platoExist.setName(plato.getName());
        platoExist.setCantidad(plato.getCantidad());
        platoExist.setMedida(plato.getMedida());
        //platoExist.setMenus(plato.getMenus());

        super.getModelRepository().save(platoExist);

    }

    @Override
    public void delete(Long id) {
        Optional<Plato> plato = super.getModelRepository().findById(id);
        if(!plato.isPresent()){
            throw new SigaAppExceptions("El plato no existe",HttpStatus.NOT_FOUND);
        }
        if(!plato.get().getMenus().isEmpty()){
            throw new SigaAppExceptions("No se puede eliminar el plato porque está asociado a uno o más menús", HttpStatus.BAD_REQUEST);
        }
        super.getModelRepository().delete(plato.get());
    }
}
