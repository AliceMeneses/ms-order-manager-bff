package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload.Button;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.buttonTitle;
import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.redColor;

public class ButtonHelper {

    public static Button getButton() {
        return Button
                .builder()
                .title(buttonTitle)
                .color(redColor)
                .build();
    }

}
