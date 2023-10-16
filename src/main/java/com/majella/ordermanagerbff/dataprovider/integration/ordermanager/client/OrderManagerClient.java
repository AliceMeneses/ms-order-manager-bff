package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-order-manager", url = "localhost:3000")
public interface OrderManagerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/menu")
    Page<MenuPlateResponse> getMenu(Pageable pageable);

    @RequestMapping(method = RequestMethod.POST, value = "/v1/orders")
    OrderResponse create(OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.PUT, value = "/v1/orders/{id}/canceled")
    void cancel(@PathVariable String id);

}
