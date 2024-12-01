package com.angelldca.sga.service;


import com.angelldca.sga.Entity.Evento;
import com.angelldca.sga.exceptions.SigaAppExceptions;
import com.angelldca.sga.repository.EventoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> findAll(){
        return eventoRepository.findAll();
    }

    public Evento create(Evento evento){
         if (evento.getHoraInicio().isAfter(evento.getHoraFin())) {
            throw new SigaAppExceptions("La hora de inicio debe ser anterior a la hora de fin", HttpStatus.BAD_REQUEST);
        }
        Optional<Evento> eventoExist = eventoRepository.findByName(evento.getName());
        if (eventoExist.isPresent()) {
            throw new SigaAppExceptions("El nombre del evento ya está en uso", HttpStatus.BAD_REQUEST);
        }
        return eventoRepository.save(evento);
    }

    public void delete(Long id){
        Optional<Evento> evento = eventoRepository.findById(id);
        if(!evento.isPresent()){
          throw new SigaAppExceptions("El evento no existe",HttpStatus.NOT_FOUND);
        }
        eventoRepository.delete(evento.get());
    }


    public List<Evento> findAllByActivo(boolean isActive){
        return this.eventoRepository.findAllByActivo(isActive);
    }
    public Evento findById(Long id){
        Optional<Evento> evento = eventoRepository.findById(id);
        if(!evento.isPresent()){
            throw new SigaAppExceptions("El evento no existe",HttpStatus.NOT_FOUND);
        }
       return evento.get();
    }


    @Transactional
    public  void changeActiveStatus(Long id, boolean active){
        Optional<Evento> evento = eventoRepository.findById(id);
        if(!evento.isPresent()){
            throw new SigaAppExceptions("El evento no existe",HttpStatus.NOT_FOUND);
        }
        this.eventoRepository.changeActiveEvent(id,active);
    }
}
