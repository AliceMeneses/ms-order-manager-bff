package com.majella.ordermanagerbff.entrypoint.api.controller.payload.response;

import com.majella.ordermanagerbff.core.domain.Plate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@EqualsAndHashCode
public class Card {

    private String plateId;
    private String title;
    private String description;
    private String image;
    private BigDecimal price;
    private Category category;

    public static Card from(Plate plate) {
        return Card
                .builder()
                .plateId(plate.getId())
                .title(plate.getName())
                .description(plate.getDescription())
                .image(plate.getImage())
                .price(plate.getPrice())
                .category(plate.getCategory())
                .build();
    }


}
