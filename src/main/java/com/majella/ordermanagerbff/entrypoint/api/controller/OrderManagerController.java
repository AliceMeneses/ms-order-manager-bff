package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.core.usecase.OrderManager;
import com.majella.ordermanagerbff.entrypoint.api.controller.contract.OrderManagerContract;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderManagerController implements OrderManagerContract {

    private final OrderManager orderManager;
    //TODO deixar esses status?
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        return orderManager.create(orderRequest);
    }

    @PutMapping("/{id}/canceled")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void cancel(String id) {
        orderManager.cancel(id);
    }

}
