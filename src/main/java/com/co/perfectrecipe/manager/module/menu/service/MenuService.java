package com.co.domainconfiguration.manager.module.menu.service;

import com.co.domainconfiguration.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.domainconfiguration.manager.crosscutting.domain.dto.MenuDto;
import com.co.domainconfiguration.manager.crosscutting.exception.ApiProcessException;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface MenuService {

    public ResponseEntity<ApiResponseDto> findMenuById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findAllMenus() throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> save(MenuDto menuDto) throws ApiProcessException;
    public ResponseEntity<ApiResponseDto> update(MenuDto menuDto) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> deleteById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findAllMenusWithChild() throws ApiProcessException;


}
