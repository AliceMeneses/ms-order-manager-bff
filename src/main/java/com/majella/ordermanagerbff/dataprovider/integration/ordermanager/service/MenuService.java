package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.service;

import com.majella.ordermanagerbff.core.gateway.MenuGateway;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService implements MenuGateway {

    private final OrderManagerClient orderManagerClient;

    @Override
    public Page<MenuPlateResponse> getMenu(Pageable pageable) {
        return orderManagerClient.getMenu(pageable);
    }

}
