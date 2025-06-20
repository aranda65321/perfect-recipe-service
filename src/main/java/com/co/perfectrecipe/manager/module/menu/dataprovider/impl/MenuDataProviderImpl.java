package com.co.domainconfiguration.manager.module.menu.dataprovider.impl;

import com.co.domainconfiguration.manager.crosscutting.domain.entity.MenuEntity;
import com.co.domainconfiguration.manager.crosscutting.domain.repository.MenuRepository;
import com.co.domainconfiguration.manager.crosscutting.domain.translators.MenuTranslator;
import com.co.domainconfiguration.manager.module.menu.dataprovider.MenuDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class MenuDataProviderImpl implements MenuDataProvider {

    private final MenuRepository menuRepository;

    @Override
    public MenuEntity saveMenu(MenuEntity menu) {
        return this.menuRepository.save(menu);
    }

    @Override
    public MenuEntity findMenuById(final UUID id) {
        MenuEntity menu = this.menuRepository.findById(id).orElse(null);
        if (menu != null) {
            menu = addChildrenToMenu(menu);
        }
        return menu;
    }

    @Override
    public List<MenuEntity> findAllMenus() {
        return this.menuRepository.findAll();
    }

    @Override
    public List<MenuEntity> findAllMenusWithChildren() {
        List<MenuEntity> menus = this.menuRepository.findAll();
        for (MenuEntity menu : menus) {
            addChildrenToMenu(menu);
        }
        return MenuTranslator.cleanRepeatMenus(menus);
    }

    @Override
    public List<MenuEntity> findAllMenusByIdParent(UUID id) {
        return this.menuRepository.findByParentId(id);
    }

    @Override
    public void deleteMenuById(UUID id) {
        this.menuRepository.deleteById(id);
    }

    private MenuEntity addChildrenToMenu(MenuEntity menuParent) {
        menuParent.setChildren(new ArrayList<>());
        List<MenuEntity> menus = this.findAllMenusByIdParent(menuParent.getId());
        if (!menus.isEmpty()) {
            menuParent.setChildren(menus);
            for (MenuEntity menu : menuParent.getChildren()) {
                menu = addChildrenToMenu(menu);
            }
        }
        return menuParent;
    }


}
