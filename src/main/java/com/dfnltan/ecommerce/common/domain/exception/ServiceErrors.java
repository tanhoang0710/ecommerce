package com.dfnltan.ecommerce.common.domain.exception;

import org.springframework.http.HttpStatus;

public class ServiceErrors {
    /*
    *  400
    * */

    public static final BusinessError INVALID_PARAMETERS = new BusinessError(400004, "Invalid parameters", HttpStatus.BAD_REQUEST);
    public static final BusinessError REQUEST_THIRD_PARTY_EXCEPTION = new BusinessError(500003, "Error occur when request to third-pary", HttpStatus.INTERNAL_SERVER_ERROR);

    private ServiceErrors() {}
}
