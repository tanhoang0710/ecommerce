package com.dfnltan.ecommerce.common.infrastructure.config.rest;

import com.dfnltan.ecommerce.common.domain.exception.BusinessError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class BaseResponse<T> {
    public static final String OK_CODE = "200";
    private T data;
    private Metadata meta = new Metadata();

    public static <T> BaseResponse<T> ofSucceeded(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.data = data;
        response.meta.code = OK_CODE;
        return response;
    }

    public static <T> BaseResponse<T> ofSucceeded(T data, Metadata meta) {
        BaseResponse<T> response = new BaseResponse<>();
        response.data = data;
        response.meta.code = OK_CODE;
        response.meta.total = meta.getTotal();
        response.meta.page = meta.getPage();
        response.meta.size = meta.getSize();
        return response;
    }

    public static <T> BaseResponse<List<T>> ofSucceeded(Page<T> data) {
        BaseResponse<List<T>> response = new BaseResponse<>();
        response.data = data.getContent();
        response.meta.code = OK_CODE;
        response.meta.total = data.getTotalElements();
        response.meta.page = data.getPageable().getPageNumber();
        response.meta.size = data.getPageable().getPageSize();
        return response;
    }

    public static <T> BaseResponse<T> ofSucceeded() {
        BaseResponse<T> response = new BaseResponse<>();
        response.meta.code = OK_CODE;
        return response;
    }

    public static BaseResponse<Void> ofFailed(BusinessError businessError, String message) {
        return ofFailed(businessError, message, null);
    }

    public static BaseResponse<Void> ofFailed(BusinessError businessError, String message, List<FieldViolation> fieldErrors) {
        BaseResponse<Void> response = new BaseResponse<>();
        response.meta.code = String.valueOf(businessError.getCode());
        response.meta.message = businessError.getMessage();
        response.meta.internalMessage = message != null ? message : businessError.getMessage();
        response.meta.errors = fieldErrors != null ? fieldErrors : new ArrayList<>();
        return response;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Metadata {
        private String code;
        private String message;
        private Integer page;
        private Integer size;
        private Long total;
        private List<FieldViolation> errors;
        private String internalMessage;
        private String requestId;
    }
}
