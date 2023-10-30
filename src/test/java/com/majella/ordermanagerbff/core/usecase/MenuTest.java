package com.majella.ordermanagerbff.core.usecase;

import com.majella.ordermanagerbff.core.gateway.MenuGateway;
import com.majella.ordermanagerbff.helper.PlateGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.majella.ordermanagerbff.helper.PlateGenerator.getPlates;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Menu Test")
@ExtendWith(MockitoExtension.class)
public class MenuTest {

    @Mock
    private MenuGateway menuGateway;

    @InjectMocks
    private Menu menu;

    @Nested
    @DisplayName("Get menu")
    class GetMenu {

        @Test
        @DisplayName("When get menu plates then return page menu plates")
        public void whenGetMenuPlatesThenReturnPageMenuPlates() {

            var plates = getPlates();

            when(menuGateway.getPlates()).thenReturn(plates);

            var result = menu.getPlates();

            assertThat(result).isEqualTo(plates);
        }

    }

}
