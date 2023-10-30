package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.core.domain.Plate;

import java.math.BigDecimal;
import java.util.List;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.Category.HAMBURGUER;

public class PlateGenerator {

    public static List<Plate> getPlates() {
        return List.of(Plate
                .builder()
                .id("653efa96ab61eb53d1896657")
                .name("X-Bacon")
                .description("")
                .price(new BigDecimal(40))
                .image("x_bacon")
                .category(HAMBURGUER)
                .build());
    }

}
