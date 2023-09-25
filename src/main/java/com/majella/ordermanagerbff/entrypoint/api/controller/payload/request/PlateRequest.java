package com.majella.ordermanagerbff.entrypoint.api.controller.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlateRequest {

    private String id;
    private Integer quantity;

}
