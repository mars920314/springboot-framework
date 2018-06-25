package mars.framework.exception;

/**
 * 常见异常归组
 */
public class WebserviceCommonExceptions {

    /*
        未知内部服务错误，handler会专门截获并记录error级别错误日志（包括causeException）
     */
    public static class ServerInternalException extends WebserviceException {
        public ServerInternalException(Exception causeException) {
            super("内部服务器错误，请稍后重试", 500);
            super.initCause(causeException);
        }
    }

    public static class AccessKeyNotExistsException extends WebserviceException {
        public AccessKeyNotExistsException() {
            super("抱歉，您当前没有可用的ACCESS KEY，请前往ACCESS KEY管理页面进行创建", 400);
        }
    }

    public static class NotAuthorizedException extends WebserviceException {
        public NotAuthorizedException() {
            super("抱歉，您的授权不足", 403);
        }
    }
}
