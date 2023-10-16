package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.MenuPlateResponse;

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
import org.springframework.data.domain.Page;

import java.io.IOException;

import static com.majella.ordermanagerbff.helper.PageMenuPlateResponseGenerator.getPageMenuPlateResponse;
import static com.majella.ordermanagerbff.helper.PageableGenerator.getPageable;
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
    private JacksonTester<Page<MenuPlateResponse>> pageMenuPlateResponseJacksonTester;

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

            var pageMenuPlateResponse = getPageMenuPlateResponse();
            var pageable = getPageable();

            when(orderManagerClient.getMenu(pageable)).thenReturn(pageMenuPlateResponse);

            var result = given()
                    .accept(JSON)
                    .contentType(JSON)
                    .queryParam("page", 0)
                    .queryParam("size", 1)
                    .when()
                    .get()
                    .then()
                    .statusCode(OK.value())
                    .extract().asString();

            var menuResult = pageMenuPlateResponseJacksonTester.parse(result).getObject();

            assertThat(menuResult)
                    .isEqualTo(pageMenuPlateResponse);
        }

    }

}
