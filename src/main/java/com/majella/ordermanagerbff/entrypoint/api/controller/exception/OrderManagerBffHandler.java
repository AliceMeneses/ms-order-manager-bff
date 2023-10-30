package com.majella.ordermanagerbff.entrypoint.api.controller.exception;

import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.exception.OrderManagerIntegrationException;
import com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload.Button;
import com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.*;
import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ImageApp.SAD_FRENCH_FRIES;

@RestControllerAdvice
public class OrderManagerBffHandler {

    @ExceptionHandler(OrderManagerIntegrationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorModel orderManagerIntegrationExceptionHandler(OrderManagerIntegrationException e) {

        var button = Button
                .builder()
                .title(buttonTitle)
                .color(redColor)
                .build();

        return ErrorModel
                .builder()
                .title(e.getMessage())
                .imageApp(SAD_FRENCH_FRIES)
                .button(button)
                .background(whiteColor)
                .build();
    }

    //TODO quais status devoler:
}
