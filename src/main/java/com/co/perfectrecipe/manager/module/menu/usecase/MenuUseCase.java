package com.co.domainconfiguration.manager.module.menu.usecase;

import com.co.domainconfiguration.manager.crosscutting.domain.dto.MenuDto;
import com.co.domainconfiguration.manager.crosscutting.exception.ApiProcessException;

import java.util.List;
import java.util.UUID;

public interface MenuUseCase {
    public MenuDto saveMenu(MenuDto menu) throws ApiProcessException;

    public MenuDto updateMenu(MenuDto menu) throws ApiProcessException;

    public MenuDto saveMenuChild(MenuDto menu) throws ApiProcessException;

    public MenuDto findMenuById(UUID id);

    public List<MenuDto> findAllMenus();

    public void deleteMenuById(UUID id);

    public List<MenuDto> findAllMenusWithChild();

}
