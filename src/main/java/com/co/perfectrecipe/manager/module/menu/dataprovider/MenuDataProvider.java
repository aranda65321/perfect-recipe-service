package com.co.domainconfiguration.manager.module.menu.dataprovider;

import com.co.domainconfiguration.manager.crosscutting.domain.entity.MenuEntity;

import java.util.List;
import java.util.UUID;

public interface MenuDataProvider {

    public MenuEntity saveMenu(MenuEntity menu);

    public MenuEntity findMenuById(UUID id);

    public List<MenuEntity> findAllMenus();

    public List<MenuEntity> findAllMenusByIdParent(UUID id);

    public void deleteMenuById(UUID id);

    public List<MenuEntity> findAllMenusWithChildren();
}
