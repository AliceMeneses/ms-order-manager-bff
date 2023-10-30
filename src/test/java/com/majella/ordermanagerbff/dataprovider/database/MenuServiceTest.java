package com.majella.ordermanagerbff.dataprovider.database;

import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.service.MenuService;
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

@DisplayName("Menu Service Test")
@ExtendWith(MockitoExtension.class)
public class MenuServiceTest {

    @Mock
    private OrderManagerClient orderManagerClient;

    @InjectMocks
    private MenuService menuService;

    @Nested
    @DisplayName("Get menu")
    class GetMenu {

        @Test
        @DisplayName("When get menu plates then return page menu plates")
        public void whenGetMenuPlatesThenReturnPageMenuPlates() {
            var plates = getPlates();

            when(orderManagerClient.getPlates()).thenReturn(plates);

            var result = menuService.getPlates();

            assertThat(result).isEqualTo(plates);
        }

    }

}
