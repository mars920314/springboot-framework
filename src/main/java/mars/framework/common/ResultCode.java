package mars.framework.common;

public enum ResultCode {
    SUCCESS(1, "success"),
    NO_DATA_ERROR(-1, "no data"),
    PARAMETER_ERROR(-2, "parameter error"),
    PARAMETER_MISSED_ERROR(-20, "parameter missed"),
    PARAMETER_MISSED_ERROR_EXT(-20, "parameter %s missed"),
    PARAMETER_VALIDATION_ERROR(-21, "parameter validation error"),
    PARAMETER_VALIDATION_ERROR_EXT(-21, "parameter validation error, %s"),
    PARAMETER_TYPE_ERROR(-22, "parameter type mismatch"),
    PARAMETER_TYPE_ERROR_EXT(-22, "parameter type mismatch, %s is not a correct value"),
    HTTP_ERROR(-23, "http error, %s"),
    RRP_ERROR(-24, "rrp error, %s"),
    NO_RESULT_ERROR(-25, "no result, %s"),
    TOO_FREQUENT_ERROR(-26, "too frequent to %s"),

//    SMS_NEED_VERIFY(-124,"need to verify by sms"),
//    SMS_NO_MOBILE(-125,"no mobile to verify by sms"),

    INVALID_USER(-123,"user is invalid"),
    LOGIN_NEED_VERIFY(-124,"need to verify"),
    LOGIN_NO_MOBILE_AND_EMAIL(-125,"no mobile and email to verify"),

    SMS_GET_CODE_NO_EMAIL(-224,"no email to verify by sms"),
    SMS_GET_CODE_NO_MOBILE(-225,"no mobile to verify by sms"),
    SMS_GET_CODE_VERIFY_TOO_FREQUENT_ERROR(-226,"too frequent to get verify code"),
    SMS_GET_CODE_FAIL(-229,"get sms code verify fail"),
    SHARE_NOTE_EXCEPTON(-231,"note shared already"),
    SMS_VERIFY_CODE_FAIL(-329,"verify code error"),

    WECHAT_BIND_CODE_ERROR(-331, "wechat bind code is invalid"),
    WECHAT_BIND_CODE_EXPIRED(-332, "wechat bind code is expired"),
    WECHAT_BIND_CODE_TOO_FREQUENT(-333, "getting wechat bind code too frequent"),
    WECHAT_DUPLICATE_BIND(-334, "user has already bind wechatId"),
    WECHAT_BIND_FAIL(-335, "user has already bind wechatId"),

    WORD_CONVERT_ERROR(-400,"error get convert response from server"),
    REDIS_ERROR(-27, "redis error , %s"),
    NEED_PRIVILEGE_ERROR(-1403, "need privilege"),
    DUPLICATED_DATA(-30, "duplicated data"),
    SUSPEND_ERROR(-3, "service suspend"),
    SYSTEM_ERROR(-4, "service busy"),
    NEED_LOGIN(-5, "need login"),
    SECURITY_ERROR(-11, "found script words in parameter, rejected for security"),
    UNKNOWN(0, "unknown"),
    NO_RP_PRIVILEGE(-1403, "no rp privilege"),
    EXTERNAL_REPORT_NOT_VALID_PARAM(-2,"not valid param "),
    EXTERNAL_REPORT_NO_PRIVILEGE(-12,"no external privilege"),

    OPERATION_MODE_ON(-9990,"system is in operation mode"),

    API_ERROR(-501, "api service error, %s"),

    SYNC_VERSION_VALIDATION_ERROR(-13, "%s");

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
