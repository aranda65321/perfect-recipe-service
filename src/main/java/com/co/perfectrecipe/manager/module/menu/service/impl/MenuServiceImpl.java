package com.co.domainconfiguration.manager.module.menu.service.impl;

import com.co.domainconfiguration.manager.crosscutting.domain.enums.TypeError;
import com.co.domainconfiguration.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.domainconfiguration.manager.crosscutting.domain.dto.MenuDto;
import com.co.domainconfiguration.manager.crosscutting.domain.translators.ApiResponseTranslator;
import com.co.domainconfiguration.manager.crosscutting.exception.ApiProcessException;
import com.co.domainconfiguration.manager.module.menu.service.MenuService;
import com.co.domainconfiguration.manager.module.menu.usecase.MenuUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuUseCase menuUseCase;

    @Override
    public ResponseEntity<ApiResponseDto> findMenuById(UUID id) throws ApiProcessException {
        try {
            MenuDto result = this.menuUseCase.findMenuById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_005);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAllMenus() throws ApiProcessException {
        try {
            List<MenuDto> result = this.menuUseCase.findAllMenus();
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_006);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> save(MenuDto menuDto) throws ApiProcessException {
        try {
            menuDto.setCreationDate(LocalDateTime.now());
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(
                    HttpStatus.OK, this.menuUseCase.saveMenu(menuDto)));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_007);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> update(MenuDto menuDto) throws ApiProcessException {
        try {
            menuDto.setModificationDate(LocalDateTime.now());
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(
                    HttpStatus.OK, this.menuUseCase.updateMenu(menuDto)));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_007);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> deleteById(UUID id) throws ApiProcessException {
        try {
            this.menuUseCase.deleteMenuById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, null));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_008);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAllMenusWithChild() throws ApiProcessException {
        try {
            List<MenuDto> result = this.menuUseCase.findAllMenusWithChild();
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_006);
        }
    }


}
