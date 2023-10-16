package com.majella.ordermanagerbff.entrypoint.api.controller.contract;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuContract {

    Page<MenuPlateResponse> getMenu(Pageable pageable);

}
