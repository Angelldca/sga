package com.angelldca.sga.controller;


import com.angelldca.sga.Entity.Medida;
import com.angelldca.sga.Entity.Plato;
import com.angelldca.sga.service.MedidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medida")
public class MedidaController {
    private final MedidaService medidaService;

    public MedidaController(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    @GetMapping
    public ResponseEntity<List<Medida>> findAll(){
        return ResponseEntity.ok(medidaService.findAll());
    }
    @PostMapping
    public ResponseEntity<Medida> create(@Valid @RequestBody Medida medida){
        Medida newMedida =  this.medidaService.create(medida);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMedida);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        medidaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Medida eliminado exitosamente");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> changeActiveStatus(@PathVariable Long id, @RequestBody Medida medida) {
        medidaService.update(medida);
        return ResponseEntity.ok("Medida actualizada");
    }

}
