package com.majella.ordermanagerbff.entrypoint.api.controller.payload.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PlateRequest {

    private String id;
    private Integer quantity;

}
