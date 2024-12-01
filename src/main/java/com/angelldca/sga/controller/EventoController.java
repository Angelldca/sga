package com.angelldca.sga.controller;


import com.angelldca.sga.Entity.Evento;
import com.angelldca.sga.exceptions.SigaAppExceptions;
import com.angelldca.sga.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> findAll(){
        return this.eventoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento){
        Evento newEvent =  this.eventoService.create(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable  Long id){
        eventoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Evento eliminado exitosamente");
    }

    @GetMapping("/isactive/{isActive}")
    public List<Evento> findAllByActivo(@PathVariable boolean isActive){
        return this.eventoService.findAllByActivo(isActive);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Evento> findById(@PathVariable Long id){

        Evento e = this.eventoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }

    @PatchMapping("/{id}/activo")
    public ResponseEntity<String> changeActiveStatus(@PathVariable Long id, @RequestParam boolean active) {
        eventoService.changeActiveStatus(id, active);
        return ResponseEntity.ok("Estado del evento actualizado correctamente");
    }

}
