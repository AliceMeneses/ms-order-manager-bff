package com.majella.ordermanagerbff.dataprovider.integration.ordermanager.exception;

public class OrderManagerIntegrationException extends RuntimeException {

    public static final String mesage = "Aconteceu um erro inesperado, tente novamente mais tarde";

    public OrderManagerIntegrationException(Throwable cause) {
        super(mesage, cause);
    }

}
