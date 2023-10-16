package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;

import java.math.BigDecimal;

public class MenuPlateResponseGenerator {

    public static MenuPlateResponse getMenuPlateResponse() {
        return MenuPlateResponse.builder()
                .id("64f4d44eb35055bb9b2576b8")
                .name("Filé de frango grelhado")
                .price(new BigDecimal(40))
                .build();
    }

}
