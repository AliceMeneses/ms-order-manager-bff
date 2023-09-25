package com.majella.ordermanagerbff.core.usecase;

import com.majella.ordermanagerbff.core.gateway.OrderManagerGateway;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManager {

    private final OrderManagerGateway orderManagerGateway;

    public List<MenuPlateResponse> getMenu(Pageable pageable) {
        return orderManagerGateway.getMenu(pageable);
    }

    public OrderResponse create(OrderRequest orderRequest) {
        return orderManagerGateway.create(orderRequest);
    }

    public void cancel(String id) {
        orderManagerGateway.cancel(id);
    }

}
