package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;

import java.util.List;

import static com.majella.ordermanagerbff.helper.PlateRequestGenerator.getPlateRequest;

public class OrderRequestGenerator {

    public static OrderRequest getOrderRequest() {
        var plate = getPlateRequest();

        return OrderRequest
                .builder()
                .plates(List.of(plate))
                .build();
    }

}
