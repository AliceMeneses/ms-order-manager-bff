package com.majella.ordermanagerbff.core.gateway;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuGateway {

    Page<MenuPlateResponse> getMenu(Pageable pageable);

}
