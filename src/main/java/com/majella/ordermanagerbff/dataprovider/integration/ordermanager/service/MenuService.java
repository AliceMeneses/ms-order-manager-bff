package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.service;

import com.majella.ordermanagerbff.core.domain.Plate;
import com.majella.ordermanagerbff.core.gateway.MenuGateway;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.client.OrderManagerClient;
import com.majella.ordermanagerbff.dataprovider.integration.ordermanager.exception.OrderManagerIntegrationException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService implements MenuGateway {

    private final OrderManagerClient orderManagerClient;

    @Override
    public List<Plate> getPlates() {
        try {
            return orderManagerClient.getPlates();
        } catch(FeignException e) {
            throw new OrderManagerIntegrationException(e);
        }
    }

}
