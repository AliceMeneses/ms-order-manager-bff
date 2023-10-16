package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.PlateRequest;

public class PlateRequestGenerator {

    public static PlateRequest getPlateRequest() {
        return PlateRequest
                .builder()
                .id("64f4d44eb25055bb9b257689")
                .quantity(2)
                .build();
    }

}
