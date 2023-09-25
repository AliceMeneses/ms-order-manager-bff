package com.majella.ordermanagerbff.entrypoint.api.controller.contract;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderManagerContract {

    OrderResponse create(@RequestBody OrderRequest orderRequest);

    void cancel(@PathVariable String id);

}
