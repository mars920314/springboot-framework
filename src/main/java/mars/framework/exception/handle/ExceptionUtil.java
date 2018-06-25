package mars.framework.exception.handle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mars.framework.common.RrpConstant;

public class ExceptionUtil {
    public static String getRequestId(HttpServletRequest request, HttpServletResponse response, String exceptionRequestId) {
        if (exceptionRequestId != null)
            return exceptionRequestId;
        else if (request.getHeader(RrpConstant.X_RRP_REQUEST_ID) != null)
            return request.getHeader(RrpConstant.X_RRP_REQUEST_ID);
        else if (response.containsHeader(RrpConstant.X_RRP_REQUEST_ID))
            return response.getHeader(RrpConstant.X_RRP_REQUEST_ID);
        return  null;
    }
}
