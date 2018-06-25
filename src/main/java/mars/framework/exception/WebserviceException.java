package mars.framework.exception;

/**
 * 常规异常
 */
public class WebserviceException extends RuntimeException {

    private int httpStatus = 400;
    private String code;
    private String requestId;

    public WebserviceException(String message) {
        super(message);
        String name = this.getClass().getSimpleName();
        if (this.getClass().getName().contains("$")) {
            String[] parts = getClass().getCanonicalName().split("\\.");
            name = parts[parts.length - 2] + "." + parts[parts.length - 1];
        }
        this.code = name;
    }

    public WebserviceException(String message, int httpStatus) {
        this(message);
        this.httpStatus = httpStatus;
    }

    public WebserviceException(String message, String code) {
        super(message);
        this.code = code;
    }

    public WebserviceException(String message, int httpStatus, String code) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    @Override
    public String toString() {
        return "RrpResponseException{" +
                "httpStatus='" + httpStatus + '\'' +
                ", requestId='" + requestId + '\'' +
                ", code='" + code + '\'' +
                ", message='" + getMessage() + "\'" +
                '}';
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebserviceException that = (WebserviceException) o;

        if (httpStatus != that.httpStatus) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (requestId != null ? !requestId.equals(that.requestId) : that.requestId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = httpStatus;
        result = 31 * result + (requestId != null ? requestId.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
