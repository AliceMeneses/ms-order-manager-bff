package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload.Button;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class CancelOrderModelResponse {

    private String title;
    private ImageApp imageApp;
    private Button button;

}
