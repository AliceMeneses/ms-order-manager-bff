package com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Button {

    private String title;
    private String color;

}
