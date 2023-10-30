package com.majella.ordermanagerbff.entrypoint.api.controller;

import com.majella.ordermanagerbff.core.usecase.OrderManager;
import com.majella.ordermanagerbff.entrypoint.api.controller.contract.OrderManagerContract;
import com.majella.ordermanagerbff.entrypoint.api.controller.exception.payload.Button;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.request.OrderRequest;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.CancelOrderModelResponse;
import com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.OrderModelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.*;
import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.constant.Constants.redColor;
import static com.majella.ordermanagerbff.entrypoint.api.controller.payload.response.ImageApp.HAPPY_FRENCH_FRIES;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderManagerController implements OrderManagerContract {

    private final OrderManager orderManager;

    //TODO deixar esses status?
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public OrderModelResponse create(OrderRequest orderRequest) {
        orderManager.create(orderRequest);

        var button = getButton();

        return OrderModelResponse
                .builder()
                .imageApp(HAPPY_FRENCH_FRIES)
                .title(orderTitle)
                .button(button)
                .build();
    }

    @PutMapping("/{id}/canceled")
    @Override
    public CancelOrderModelResponse cancel(String id) {
        orderManager.cancel(id);

        var button = getButton();

        return CancelOrderModelResponse
                .builder()
                .imageApp(HAPPY_FRENCH_FRIES)
                .title(cancellationTitle)
                .button(button)
                .build();
    }

    private static Button getButton() {
        return Button
                .builder()
                .title(buttonTitle)
                .color(redColor)
                .build();
    }

}
