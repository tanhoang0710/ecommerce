package com.dfnltan.ecommerce.common.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@Setter
public class BusinessError {
    private int code;
    private String message;
    private HttpStatus httpStatus;

    public BusinessError(String message) {
        this.code = HttpStatus.BAD_REQUEST.value();
        this.message = message;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public BusinessError(String code, String message, HttpStatus httpStatus) {
        this.code = Integer.parseInt(code);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
