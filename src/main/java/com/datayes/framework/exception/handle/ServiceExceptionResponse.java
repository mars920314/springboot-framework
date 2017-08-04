package com.datayes.framework.exception.handle;

/**
 * 服务层异常返回数据模型，用于jackson序列化
 */
public class ServiceExceptionResponse {
    private String requestId;
    private String code;
    private String message;

    @Override
    public String toString() {
        return "RrpExceptionResponse{" +
                "requestId='" + requestId + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
