package com.datayes.framework.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * fieldMessageMap校验异常
 */
public class WebserviceValidationException extends RuntimeException {

    private int httpStatus = 400;
    private String code = "RrpValidationException";
    private String requestId;
    private Map<String, String> fieldMessageMap;

    public WebserviceValidationException(BindingResult bindingResult){
        fieldMessageMap = new HashMap<String, String>();
        for (FieldError fieldError: bindingResult.getFieldErrors()) {
            fieldMessageMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public WebserviceValidationException(Map<String, String> fieldMessageMap){
        this.fieldMessageMap = fieldMessageMap;
    }

    public Map<String, String> getFieldMessageMap() {
        return fieldMessageMap;
    }

    public void setFieldMessageMap(Map<String, String> fieldMessageMap) {
        this.fieldMessageMap = fieldMessageMap;
    }

    @Override
    public String toString() {
        return "RrpValidationException{" +
                "httpStatus=" + httpStatus +
                ", code='" + code + '\'' +
                ", requestId='" + requestId + '\'' +
                ", fieldMessageMap=" + fieldMessageMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebserviceValidationException that = (WebserviceValidationException) o;

        if (httpStatus != that.httpStatus) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (fieldMessageMap != null ? !fieldMessageMap.equals(that.fieldMessageMap) : that.fieldMessageMap != null)
            return false;
        if (requestId != null ? !requestId.equals(that.requestId) : that.requestId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = httpStatus;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (requestId != null ? requestId.hashCode() : 0);
        result = 31 * result + (fieldMessageMap != null ? fieldMessageMap.hashCode() : 0);
        return result;
    }

}
