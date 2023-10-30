package com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ImageApp;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorModel {

    private String title;
    private ImageApp imageApp;
    private Button button;
    private String background;

}
