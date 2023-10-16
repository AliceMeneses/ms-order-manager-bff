package com.majella.ordermanagerbff.core.gateway;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;

public interface OrderManagerGateway {

    OrderResponse create(OrderRequest orderRequest);

    void cancel(String id);

}
