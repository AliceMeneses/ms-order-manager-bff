package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.service;

import com.majella.ordermanagerbff.core.gateway.OrderManagerGateway;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.exception.OrderManagerIntegrationException;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderManagerService implements OrderManagerGateway {

    private final OrderManagerClient orderManagerClient;

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        try {
            return orderManagerClient.create(orderRequest);
        } catch(FeignException e) {
            throw new OrderManagerIntegrationException(e);
        }
    }

    @Override
    public void cancel(String id) {
        try {
            orderManagerClient.cancel(id);
        } catch(FeignException e) {
            throw new OrderManagerIntegrationException(e);
        }
    }

}
