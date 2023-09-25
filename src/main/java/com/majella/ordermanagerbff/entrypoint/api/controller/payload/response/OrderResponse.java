package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import com.majella.ordermanagerbff.core.domain.Status;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderResponse {

    private String id;
    private Status status;
    private List<PlateResponse> plates;
    private BigDecimal totalPrice;
}
