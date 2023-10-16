package com.majella.ordermanagerbff.core.usecase;

import com.majella.ordermanagerbff.core.gateway.OrderManagerGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.majella.ordermanagerbff.helper.OrderRequestGenerator.getOrderRequest;
import static com.majella.ordermanagerbff.helper.OrderResponseGenerator.getOrderResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Order Manager Test")
@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {

    @Mock
    private OrderManagerGateway orderManagerGateway;

    @InjectMocks
    private OrderManager orderManager;

    @Nested
    @DisplayName("Create Test")
    class CreateTest {

        @Test
        @DisplayName("when create order then return order response")
        public void whenCreateOrderThenReturnOrderResponse() {
            var orderRequest = getOrderRequest();
            var orderResponseExpected = getOrderResponse();

            when(orderManagerGateway.create(orderRequest)).thenReturn(orderResponseExpected);

            var result = orderManager.create(orderRequest);

            assertThat(result).isEqualTo(orderResponseExpected);
        }

    }

    @Nested
    @DisplayName("Cancel Test")
    class CancelTest {

        @Test
        @DisplayName("When cancel order then cancel order")
        public void whenCancelOrderThenCancelOrder() {
            String id = "64f4d44eb35055bb9b2576b8";
            orderManager.cancel(id);

            verify(orderManagerGateway).cancel(id);
        }

    }

}
