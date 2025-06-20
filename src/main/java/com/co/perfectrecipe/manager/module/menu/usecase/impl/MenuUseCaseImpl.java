package com.co.domainconfiguration.manager.module.menu.usecase.impl;

import com.co.domainconfiguration.manager.crosscutting.domain.entity.MenuEntity;
import com.co.domainconfiguration.manager.module.menuxsite.dataprovider.MenuSiteDataProvider;
import com.co.domainconfiguration.manager.crosscutting.domain.dto.MenuDto;
import com.co.domainconfiguration.manager.crosscutting.domain.translators.MenuTranslator;
import com.co.domainconfiguration.manager.crosscutting.exception.ApiProcessException;
import com.co.domainconfiguration.manager.module.menu.dataprovider.MenuDataProvider;
import com.co.domainconfiguration.manager.module.menu.usecase.MenuUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Log4j2
@AllArgsConstructor
public class MenuUseCaseImpl implements MenuUseCase {

    private final MenuDataProvider menuDataProvider;

    @Autowired
    private MenuSiteDataProvider menuSiteDataProvider;

    @Override
    public MenuDto saveMenu(MenuDto menu) throws ApiProcessException {
        log.info("Realizando persistencia de Menu con name: {}", menu.getName());
        MenuEntity menuEntity = MenuTranslator.toMenuEntity(menu);
        if (menu.getParent() != null) {
            MenuEntity parent = this.menuDataProvider.findMenuById(menu.getParent());
            if (parent != null) {
                menuEntity.setParentId(parent.getId());
            }
        }
        return MenuTranslator.toMenuDto(this.menuDataProvider.saveMenu(menuEntity));
    }

    @Override
    public MenuDto updateMenu(MenuDto menu) throws ApiProcessException {
        log.info("Realizando actualización de Menu con id: {}", menu.getId());
        MenuEntity menuUpdate = MenuTranslator.updateMenu(menu, this.menuDataProvider.findMenuById(menu.getId()));
        if (menu.getParent() != null) {
            MenuEntity parent = this.menuDataProvider.findMenuById(menu.getParent());
            if (parent != null) {
                menuUpdate.setParentId(parent.getId());
            }
        }
        return MenuTranslator.toMenuDto(this.menuDataProvider.saveMenu(menuUpdate));
    }

    @Override
    public MenuDto saveMenuChild(MenuDto menu) throws ApiProcessException {
        log.info("Realizando persistencia de Menu hijo con name: {}", menu.getName());
        MenuEntity parent = this.menuDataProvider.findMenuById(menu.getParent());
        if (parent != null) {
            MenuEntity save = MenuTranslator.toMenuEntity(menu);
            save.setParentId(parent.getId());
            return MenuTranslator.toMenuDto(this.menuDataProvider.saveMenu(save));
        }
        return null;
    }

    @Override
    public MenuDto findMenuById(UUID id) {
        log.info("Realizando busqueda de Menu con id {}", id);
        return MenuTranslator.toMenuDto(this.menuDataProvider.findMenuById(id));
    }

    @Override
    public List<MenuDto> findAllMenus() {
        log.info("Realizando busqueda de todos los Menus");
        return MenuTranslator.toListMenuDto(this.menuDataProvider.findAllMenus());
    }

    @Override
    public void deleteMenuById(UUID id) {
        log.info("Realizando borrado de Menu con id {}", id);
        this.menuDataProvider.deleteMenuById(id);
    }

    @Override
    public List<MenuDto> findAllMenusWithChild() {
        log.info("Realizando busqueda de todos los Menus con hijos");
        return MenuTranslator.toListMenuDto(this.menuDataProvider.findAllMenusWithChildren());
    }


}
