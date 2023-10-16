package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.service;

import com.majella.ordermanagerbff.core.gateway.OrderManagerGateway;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManagerService implements OrderManagerGateway {

    private final OrderManagerClient orderManagerClient;

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        return orderManagerClient.create(orderRequest);
    }

    @Override
    public void cancel(String id) {
        orderManagerClient.cancel(id);
    }

}
