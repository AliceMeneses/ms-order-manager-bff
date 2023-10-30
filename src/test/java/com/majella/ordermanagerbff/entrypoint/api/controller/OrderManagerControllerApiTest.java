package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.CancelOrderModelResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderModelResponse;
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

import static com.majella.ordermanagerbff.helper.CancelOrderModelResponseHelper.getCancelOrderModelResponse;
import static com.majella.ordermanagerbff.helper.OrderModelResponseHelper.getOrderModelResponse;
import static com.majella.ordermanagerbff.helper.OrderRequestGenerator.getOrderRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureJsonTesters
public class OrderManagerControllerApiTest {

    @MockBean
    private OrderManagerClient orderManagerClient;

    @Autowired
    private JacksonTester<OrderRequest> orderRequestJacksonTester;

    @Autowired
    private JacksonTester<OrderModelResponse> orderModelResponseJacksonTester;

    @Autowired
    private JacksonTester<CancelOrderModelResponse> cancelOrderModelResponseJacksonTester;

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
        @DisplayName("When create order then return order model response and status 201")
        public void whenCreateOrderThenReturnOrderModelResponseAndStatus201() throws IOException {

            var orderRequest = getOrderRequest();
            var expected = getOrderModelResponse();

            String result = given()
                    .accept(JSON)
                    .contentType(JSON)
                    .body(orderRequestJacksonTester.write(orderRequest).getJson())
                    .when()
                    .post()
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .extract().asString();

            var orderResult = orderModelResponseJacksonTester.parse(result).getObject();

            assertThat(orderResult)
                    .isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("Cancel Order Test")
    class CancelOrderTest {

        @Test
        @DisplayName("When cancel order then cancel order and return status 204")
        public void whenCancelOrderThenCancelOrderAndReturnStatus204() throws IOException {
            var expected = getCancelOrderModelResponse();

            var result = given()
                    .accept(JSON)
                    .pathParam("id", "64fe82fbf968b2939fdd01c7")
                    .basePath("{id}/canceled")
                    .when()
                    .put()
                    .then()
                    .statusCode(OK.value())
                    .extract().asString();

            var cancelResult = cancelOrderModelResponseJacksonTester.parse(result).getObject();

            assertThat(cancelResult)
                    .isEqualTo(expected);
        }
    }

}
