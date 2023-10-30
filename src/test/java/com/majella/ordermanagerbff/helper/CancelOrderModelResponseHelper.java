package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.CancelOrderModelResponse;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.cancellationTitle;
import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ImageApp.HAPPY_FRENCH_FRIES;
import static com.majella.ordermanagerbff.helper.ButtonHelper.getButton;

public class CancelOrderModelResponseHelper {

    public static CancelOrderModelResponse getCancelOrderModelResponse() {
        var button = getButton();

        return CancelOrderModelResponse
                .builder()
                .imageApp(HAPPY_FRENCH_FRIES)
                .title(cancellationTitle)
                .button(button)
                .build();
    }

}
