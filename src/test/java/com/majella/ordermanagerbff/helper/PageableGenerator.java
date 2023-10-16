package com.majella.ordermanagerbff.helper;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableGenerator {

    public static Pageable getPageable() {
        return  PageRequest.of(0,1);
    }


}
