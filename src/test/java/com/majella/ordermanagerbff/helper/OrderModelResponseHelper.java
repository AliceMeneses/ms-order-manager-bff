package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderModelResponse;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.orderTitle;
import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ImageApp.HAPPY_FRENCH_FRIES;
import static com.majella.ordermanagerbff.helper.ButtonHelper.getButton;

public class OrderModelResponseHelper {

    public static OrderModelResponse getOrderModelResponse() {
        var button = getButton();

        return OrderModelResponse
                .builder()
                .imageApp(HAPPY_FRENCH_FRIES)
                .title(orderTitle)
                .button(button)
                .build();
    }

}
