package com.angelldca.sga.controller;


import com.angelldca.sga.Entity.Comedor;
import com.angelldca.sga.Entity.Medida;
import com.angelldca.sga.service.ComedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comedor")
public class ComedorController {

    private final ComedorService comedorService;

    public ComedorController(ComedorService comedorService) {
        this.comedorService = comedorService;
    }
    @GetMapping
    public ResponseEntity<List<Comedor>> findAll(){
        return ResponseEntity.ok(comedorService.findAll());
    }
    @PostMapping
    public ResponseEntity<Comedor> create(@Valid @RequestBody Comedor c){
        Comedor newComedor =  this.comedorService.create(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComedor);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        comedorService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Comedor eliminado exitosamente");
    }
    @PatchMapping("/{id}")
    public ResponseEntity<String> changeActiveStatus(@PathVariable Long id, @RequestBody Comedor comedor) {
        comedorService.update(comedor);
        return ResponseEntity.ok("Comedor actualizado");
    }
}
