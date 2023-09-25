package com.majella.ordermanagerbff.entrypoint.api.controller.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private List<PlateRequest> plates;

}
