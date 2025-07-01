package com.co.perfectrecipe.manager.crosscutting.domain.enums;

import org.springframework.http.HttpStatus;

public enum TypeError {
    IR_001("IR_001", "Error consultando recipe", HttpStatus.NOT_FOUND),

    IR_002("IR_002", "Error guardando recipe", HttpStatus.CONFLICT),

    IR_003("IR_003", "Error actualizando recipe", HttpStatus.CONFLICT),

    IR_004("IR_004", "Error suprimiendo recipe", HttpStatus.CONFLICT),
    IR_005("IR_005", "Error consultado Menu por id", HttpStatus.CONFLICT),
    IR_006("IR_006", "Error consultando todos los Menus", HttpStatus.CONFLICT),
    IR_007("IR_007", "Error persistiendo Menu", HttpStatus.CONFLICT),
    IR_008("IR_008", "Error suprimiendo Menu", HttpStatus.CONFLICT),
    IR_009("IR_009", "Error consultado MenuSite por id", HttpStatus.CONFLICT),
    IR_010("IR_010", "Error consultando todos los MenuSite", HttpStatus.CONFLICT),
    IR_011("IR_011", "Error persistiendo MenuSite", HttpStatus.CONFLICT),
    IR_012("IR_012", "Error suprimiendo MenuSite", HttpStatus.CONFLICT),
    IR_013("IR_013", "Error consultando menuTypes", HttpStatus.CONFLICT),
    IR_014("IR_014", "Error persistiendo Role", HttpStatus.CONFLICT),
    IR_015("IR_015", "Error buscando Role por id", HttpStatus.CONFLICT),
    IR_016("IR_016", "Error buscando todos los roles", HttpStatus.CONFLICT),
    IR_017("IR_017", "Error Usuario ya existe", HttpStatus.CONFLICT),
    IR_018("IR_018", "Error creando usuario", HttpStatus.CONFLICT),
    IR_019("IR_019", "Error eliminando role", HttpStatus.CONFLICT),
    IR_020("IR_02O", "Error actulizando usuario", HttpStatus.CONFLICT),
    IR_021("IR_021", "Error eliminando usuario", HttpStatus.CONFLICT),

    IR_022("IR_022", "Error actualizando site", HttpStatus.CONFLICT),
    IR_023("IR_023", "Error guardando imagen en servidor", HttpStatus.CONFLICT);


    private String code;
    private String description;

    private HttpStatus httpCode;

    TypeError(String code, String description, HttpStatus httpCode) {
        this.code = code;
        this.description = description;
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }
}
