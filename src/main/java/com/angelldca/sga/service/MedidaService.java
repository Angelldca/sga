package com.angelldca.sga.service;


import com.angelldca.sga.Entity.Medida;
import com.angelldca.sga.repository.MedidaRepository;
import org.springframework.stereotype.Service;

@Service
public class MedidaService extends GenericService<Medida,Long> {
   private final MedidaRepository medidaRepository;
    public MedidaService(MedidaRepository medidaRepository) {
        super(medidaRepository);
        this.medidaRepository = medidaRepository;
    }
    public void update(Medida medida){
        Medida medidaExist = super.findById(medida.getId());
        medidaExist.setName(medida.getName());

        super.getModelRepository().save(medidaExist);

    }
}
