package com.majella.ordermanagerbff.core.domain;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.Category;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Plate {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private String image;

}
