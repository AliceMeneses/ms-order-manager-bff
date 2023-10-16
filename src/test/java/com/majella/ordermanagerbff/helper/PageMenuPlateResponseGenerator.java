package com.majella.ordermanagerbff.helper;

import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static com.majella.ordermanagerbff.helper.MenuPlateResponseGenerator.getMenuPlateResponse;
import static com.majella.ordermanagerbff.helper.PageableGenerator.getPageable;

public class PageMenuPlateResponseGenerator {

    public static Page<MenuPlateResponse> getPageMenuPlateResponse() {

        var menuPlateResponse = getMenuPlateResponse();
        var pageable = getPageable();

        return new PageImpl<>(List.of(menuPlateResponse), pageable, 1);
    }

}
