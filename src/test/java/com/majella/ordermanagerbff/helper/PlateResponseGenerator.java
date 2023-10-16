package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.PlateResponse;

import java.math.BigDecimal;

public class PlateResponseGenerator {

    public static PlateResponse getPlateResponse() {
        return PlateResponse
                .builder()
                .name("Macajuaba")
                .price(new BigDecimal(40))
                .quantity(2)
                .build();
    }

}
