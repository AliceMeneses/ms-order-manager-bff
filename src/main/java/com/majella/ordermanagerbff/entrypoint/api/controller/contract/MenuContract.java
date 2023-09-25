package com.majella.ordermanagerbff.entrypoint.api.controller.contract;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuContract {

    List<MenuPlateResponse> getMenu(Pageable pageable);

}
