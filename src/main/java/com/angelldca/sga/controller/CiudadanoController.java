package com.angelldca.sga.controller;


import com.angelldca.sga.Entity.Ciudadano;
import com.angelldca.sga.Entity.Medida;
import com.angelldca.sga.service.CiudadanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ciudadano")
public class CiudadanoController {
    private final CiudadanoService ciudadanoService;

    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping
    public ResponseEntity<List<Ciudadano>> findAll(){
        return ResponseEntity.ok(ciudadanoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Ciudadano> create(@Valid @RequestBody Ciudadano c){
        Ciudadano newCiudadano =  this.ciudadanoService.create(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCiudadano);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        ciudadanoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ciudadano eliminado exitosamente");
    }


}
