package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client;

import com.majella.ordermanagerbff.core.domain.Plate;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-order-manager", url = "localhost:3000")
public interface OrderManagerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/menu")
    List<Plate> getPlates();

    @RequestMapping(method = RequestMethod.POST, value = "/v1/orders")
    OrderResponse create(OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.PUT, value = "/v1/orders/{id}/canceled")
    void cancel(@PathVariable String id);

}
