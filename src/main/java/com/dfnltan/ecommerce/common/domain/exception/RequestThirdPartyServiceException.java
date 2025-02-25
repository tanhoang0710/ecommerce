package com.dfnltan.ecommerce.common.domain.exception;

public class RequestThirdPartyServiceException extends ServiceException {
    public RequestThirdPartyServiceException(String service, String action, String message) {
        super(
                ServiceErrors.REQUEST_THIRD_PARTY_EXCEPTION,
                String.format("Service: [%s] - Action: [%s] - Message: [%s]", service, action, message)
        );
    }
}
