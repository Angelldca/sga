package com.angelldca.sga.service;

import com.angelldca.sga.Entity.Menu;
import com.angelldca.sga.Entity.Plato;
import com.angelldca.sga.repository.IRepository;
import com.angelldca.sga.repository.MenuRepository;
import org.springframework.stereotype.Service;


@Service
public class MenuService extends GenericService<Menu,Long>{
    private final MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository) {
        super(menuRepository);
        this.menuRepository = menuRepository;
    }
    public void update(Menu menu){
        Menu menuExist = super.findById(menu.getId());
        menuExist.setPlatos(menu.getPlatos());
        double price = 0;
        for (Plato p: menuExist.getPlatos()){
             price += p.getPrice();
        }
        menuExist.setTotal_price(price);
        super.getModelRepository().save(menuExist);

    }
}
