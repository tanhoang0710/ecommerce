package com.dfnltan.ecommerce.common.domain.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private final BusinessError businessError;

    public ServiceException(BusinessError businessError) {
        super(businessError.getMessage());
        this.businessError = businessError;
    }

    public ServiceException(BusinessError businessError, String message, Throwable cause) {
        super(message, cause);
        this.businessError = businessError;
    }

    public ServiceException(BusinessError businessError, String message) {
        super(message);
        this.businessError = businessError;
    }
}
