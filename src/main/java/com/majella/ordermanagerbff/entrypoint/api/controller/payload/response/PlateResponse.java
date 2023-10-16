package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PlateResponse {

    private String name;
    private BigDecimal price;
    private Integer quantity;

}
