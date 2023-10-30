package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ToolbarItem;

import java.util.Set;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.Category.HAMBURGUER;

public class ToolbarItemHelper {

    public static Set<ToolbarItem> getToolbarItems() {
        return Set.of(ToolbarItem
                .builder()
                .title(HAMBURGUER.getDescription())
                .category(HAMBURGUER)
                .build());
    }

}
