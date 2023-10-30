package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.core.usecase.Menu;
import com.majella.ordermanagerbff.entrypoint.api.controller.contract.MenuContract;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.Card;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuModelResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ToolbarItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/menu")
@RequiredArgsConstructor
public class MenuController implements MenuContract {

    private final Menu menu;

    @GetMapping
    @Override
    public MenuModelResponse getMenu() {
        var plates = menu.getPlates();
        var cards = plates.stream().map(Card::from).toList();
        var toolbarItems = plates.stream().map(ToolbarItem::from).collect(Collectors.toSet());
        return MenuModelResponse
                .builder()
                .cards(cards)
                .toolbarItems(toolbarItems)
                .build();
    }

}
