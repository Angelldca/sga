package com.angelldca.sga.controller;


import com.angelldca.sga.Entity.Evento;
import com.angelldca.sga.Entity.Plato;
import com.angelldca.sga.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/plato")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public ResponseEntity<List<Plato>> findAll(){
        return ResponseEntity.ok(platoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Plato> create(@Valid @RequestBody Plato plato){
        Plato newPlato =  this.platoService.create(plato);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlato);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        platoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Plato eliminado exitosamente");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> changeActiveStatus(@PathVariable Long id, @RequestBody Plato plato) {
        platoService.update(plato);
        return ResponseEntity.ok("Plato actualizado");
    }

}
