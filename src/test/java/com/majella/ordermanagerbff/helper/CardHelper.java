package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.Card;

import java.util.List;

import static com.majella.ordermanagerbff.helper.PlateGenerator.getPlates;

public class CardHelper {

    public static List<Card> getCards() {
        var plate = getPlates().get(0);

        return List.of(Card
                .builder()
                .plateId(plate.getId())
                .title(plate.getName())
                .description(plate.getDescription())
                .image(plate.getImage())
                .price(plate.getPrice())
                .category(plate.getCategory())
                .build());
    }

}
