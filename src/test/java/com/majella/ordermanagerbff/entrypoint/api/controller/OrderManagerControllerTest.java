package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.core.usecase.OrderManager;
import com.majella.ordermanagerbff.helper.OrderModelResponseHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.majella.ordermanagerbff.helper.OrderModelResponseHelper.getOrderModelResponse;
import static com.majella.ordermanagerbff.helper.OrderRequestGenerator.getOrderRequest;
import static com.majella.ordermanagerbff.helper.OrderResponseGenerator.getOrderResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Order Manager Controller Test")
@ExtendWith(MockitoExtension.class)
public class OrderManagerControllerTest {

    @Mock
    private OrderManager orderManager;

    @InjectMocks
    private OrderManagerController orderManagerController;

    @Nested
    @DisplayName("Create Test")
    class CreateTest {

        @Test
        @DisplayName("when create order then return order response")
        public void whenCreateOrderThenReturnOrderResponse() {
            var orderRequest = getOrderRequest();
            var orderModelResponseExpected = getOrderModelResponse();

            var result = orderManagerController.create(orderRequest);

            assertThat(result).isEqualTo(orderModelResponseExpected);

            verify(orderManager).create(orderRequest);
        }

    }

    @Nested
    @DisplayName("Cancel Test")
    class CancelTest {

        @Test
        @DisplayName("When cancel order then cancel order")
        public void whenCancelOrderThenCancelOrder() {
            String id = "64f4d44eb35055bb9b2576b8";
            orderManagerController.cancel(id);

            verify(orderManager).cancel(id);
        }

    }

}
