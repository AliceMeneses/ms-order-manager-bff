package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.core.domain.Status;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;

import java.math.BigDecimal;
import java.util.List;

import static com.majella.ordermanagerbff.helper.PlateResponseGenerator.getPlateResponse;

public class OrderResponseGenerator {

    public static OrderResponse getOrderResponse() {

        var plate = getPlateResponse();

        return OrderResponse
                .builder()
                .id("64f4d44eb35055bb9b2576b8")
                .status(Status.IN_PRODUCTION)
                .plates(List.of(plate))
                .totalPrice(new BigDecimal(80))
                .build();
    }

}
