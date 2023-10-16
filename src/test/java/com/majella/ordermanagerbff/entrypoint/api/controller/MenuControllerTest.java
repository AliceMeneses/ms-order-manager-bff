package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.core.usecase.Menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.majella.ordermanagerbff.helper.PageMenuPlateResponseGenerator.getPageMenuPlateResponse;
import static com.majella.ordermanagerbff.helper.PageableGenerator.getPageable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Menu Controller Test")
@ExtendWith(MockitoExtension.class)
public class MenuControllerTest {

    @Mock
    private Menu menu;

    @InjectMocks
    private MenuController menuController;

    @Nested
    @DisplayName("Pagination menu test")
    class PaginationMenuTest {

        @Test
        @DisplayName("When get menu plates then return menu plates")
        public void whenGetMenuPlatesThenReturnMenuPlates() {
            var pageable = getPageable();
            var pageMenuPlateResponseExpected = getPageMenuPlateResponse();

            when(menu.getMenu(pageable)).thenReturn(pageMenuPlateResponseExpected);

            var result =  menuController.getMenu(pageable);

            assertThat(result).isEqualTo(pageMenuPlateResponseExpected);
        }

    }

}
