package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.core.usecase.OrderManager;
import com.majella.ordermanagerbff.entrypoint.api.controller.contract.MenuContract;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/menu")
@RequiredArgsConstructor
public class MenuController implements MenuContract {

    private final OrderManager orderManager;

    @GetMapping
    @Override
    public List<MenuPlateResponse> getMenu(Pageable pageable) {
        return orderManager.getMenu(pageable);
    }

}
