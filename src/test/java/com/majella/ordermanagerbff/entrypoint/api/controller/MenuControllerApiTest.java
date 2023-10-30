package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuModelResponse;

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

import java.io.IOException;

import static com.majella.ordermanagerbff.helper.MenuModelResponseGenerator.getMenuModelResponseGenerator;
import static com.majella.ordermanagerbff.helper.PlateGenerator.getPlates;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureJsonTesters
public class MenuControllerApiTest {

    @MockBean
    private OrderManagerClient orderManagerClient;

    @Autowired
    private JacksonTester<MenuModelResponse> menuModelResponseJacksonTester;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.baseURI = DEFAULT_URI + "/v1/menu";
    }

    @Nested
    @DisplayName("Get menu")
    class GetMenu {

        @Test
        @DisplayName("When get menu plates then return page menu plates")
        public void whenGetMenuPlatesThenReturnPageMenuPlatesAndStatus200() throws IOException {

            var plates = getPlates();
            var expected = getMenuModelResponseGenerator();

            when(orderManagerClient.getPlates()).thenReturn(plates);

            var result = given()
                    .accept(JSON)
                    .when()
                    .get()
                    .then()
                    .statusCode(OK.value())
                    .extract().asString();

            var menuResult = menuModelResponseJacksonTester.parse(result).getObject();

            assertThat(menuResult)
                    .isEqualTo(expected);
        }

    }

}
