package com.majella.ordermanagerbff.core.gateway;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderManagerGateway {

    List<MenuPlateResponse> getMenu(Pageable pageable);

    OrderResponse create(OrderRequest orderRequest);

    void cancel(String id);

}
