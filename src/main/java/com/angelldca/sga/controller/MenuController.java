package com.angelldca.sga.controller;


import com.angelldca.sga.Entity.Menu;
import com.angelldca.sga.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/menu")
@RestController
public class MenuController {
     private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Menu> create(@Valid  @RequestBody  Menu menu){

        return ResponseEntity.ok(menuService.create(menu));
    }
    @GetMapping
    public ResponseEntity<List<Menu>> findAll(){
        return ResponseEntity.ok(menuService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Menu> findById(@PathVariable Long id){
        return ResponseEntity.ok(menuService.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        menuService.delete(id);
        return ResponseEntity.ok("Menú eliminado");
    }

}
