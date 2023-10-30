package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import lombok.Getter;

@Getter
public enum Category {

    PORTION("Porção"),
    HAMBURGUER("Hambúrguer"),
    DRINK("Bebidas");

    private String description;

    Category(String description) {
        this.description = description;
    }

}
