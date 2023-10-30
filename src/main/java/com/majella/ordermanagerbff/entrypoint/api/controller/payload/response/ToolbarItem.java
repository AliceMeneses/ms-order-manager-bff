package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import com.majella.ordermanagerbff.core.domain.Plate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class ToolbarItem {

    private Category category;
    private String title;

    public static ToolbarItem from(Plate plate) {
        return ToolbarItem
                .builder()
                .category(plate.getCategory())
                .title(plate.getCategory().getDescription())
                .build();
    }

}
