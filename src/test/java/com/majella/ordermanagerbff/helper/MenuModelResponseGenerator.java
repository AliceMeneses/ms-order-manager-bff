package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuModelResponse;

import static com.majella.ordermanagerbff.helper.CardHelper.getCards;
import static com.majella.ordermanagerbff.helper.ToolbarItemHelper.getToolbarItems;

public class MenuModelResponseGenerator {

    public static MenuModelResponse getMenuModelResponseGenerator() {
        var toolbarItems = getToolbarItems();
        var cards = getCards();

        return MenuModelResponse
                .builder()
                .toolbarItems(toolbarItems)
                .cards(cards)
                .build();
    }

}
