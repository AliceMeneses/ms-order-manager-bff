package com.majella.ordermanagerbff.entrypoint.api.controller.contract;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.CancelOrderModelResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderModelResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderManagerContract {

    OrderModelResponse create(@RequestBody OrderRequest orderRequest);

    CancelOrderModelResponse cancel(@PathVariable String id);

}
