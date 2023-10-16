package com.majella.ordermanagerbff.entrypoint.api.controller.payload.request;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderRequest {

    private List<PlateRequest> plates;

}
