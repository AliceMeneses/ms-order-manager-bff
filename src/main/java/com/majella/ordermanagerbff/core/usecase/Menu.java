package com.majella.ordermanagerbff.core.usecase;

import com.majella.ordermanagerbff.core.gateway.MenuGateway;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Menu {

    private final MenuGateway menuGateway;

    public Page<MenuPlateResponse> getMenu(Pageable pageable) {
        return menuGateway.getMenu(pageable);
    }

}
