package com.majella.ordermanagerbff.core.usecase;

import com.majella.ordermanagerbff.core.domain.Plate;
import com.majella.ordermanagerbff.core.gateway.MenuGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Menu {

    private final MenuGateway menuGateway;

    public List<Plate> getPlates() {
        return menuGateway.getPlates();
    }

}
