package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderResponse;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static com.majella.ordermanagerbff.helper.OrderRequestGenerator.getOrderRequest;
import static com.majella.ordermanagerbff.helper.OrderResponseGenerator.getOrderResponse;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureJsonTesters
public class OrderManagerControllerApiTest {

    @MockBean
    private OrderManagerClient orderManagerClient;

    @Autowired
    private JacksonTester<OrderRequest> orderRequestJacksonTester;

    @Autowired
    private JacksonTester<OrderResponse> orderResponseJacksonTester;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.baseURI = DEFAULT_URI + "/v1/orders";
    }

    @Nested
    @DisplayName("Create Order Test")
    class CreateOrderTest {

        @Test
        @DisplayName("When create order then return order response and status 201")
        public void whenCreateOrderThenReturnOrderResponseAndStatus201() throws IOException {

            var orderRequest = getOrderRequest();
            var orderResponseExpected = getOrderResponse();

            when(orderManagerClient.create(orderRequest)).thenReturn(orderResponseExpected);

            String result = given()
                    .accept(JSON)
                    .contentType(JSON)
                    .body(orderRequestJacksonTester.write(orderRequest).getJson())
                    .when()
                    .post()
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .extract().asString();

            var orderResult = orderResponseJacksonTester.parse(result).getObject();

            assertThat(orderResult)
                    .isEqualTo(orderResponseExpected);
        }
    }

    @Nested
    @DisplayName("Cancel Order Test")
    class CancelOrderTest {

        @Test
        @DisplayName("When cancel order then cancel order and return status 204")
        public void whenCancelOrderThenCancelOrderAndReturnStatus204() {

            given()
                    .accept(JSON)
                    .pathParam("id", "64fe82fbf968b2939fdd01c7")
                    .basePath("{id}/canceled")
                    .when()
                    .put()
                    .then()
                    .body(blankOrNullString())
                    .statusCode(NO_CONTENT.value());
        }
    }

}
