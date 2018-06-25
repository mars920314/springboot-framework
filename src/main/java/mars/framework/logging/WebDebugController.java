package mars.framework.logging;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangzheyuan on 2014/7/29.
 */
@Controller
@ConditionalOnExpression("${logging.has_web_debug_appender:${rrp_web_framework.is_debug:true}}")
public class WebDebugController {
    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("${logging.web_debug_path:/debug}")
    public void index(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("text/plain;charset=UTF-8");

        ServletOutputStream stream = response.getOutputStream();
        String currentUser = getCurrentUser();
        WebDebugAppender.addWebLog(currentUser, stream);

        log.info("[{}] debug begin", currentUser);

        forceFlush(stream);
        response.flushBuffer();

        while(true){
            try {
                Thread.sleep(1000);
                stream.print("");
                stream.flush();
            } catch (Exception ex) {
                log.info("[{}] debug finish", currentUser);
                return;
            }
        }
    }

    private void forceFlush(ServletOutputStream stream) throws IOException {
        for (int i = 0; i < 1000; i++)
            stream.print(" ");
    }

    private String getCurrentUser() {
        String currentUser = MDC.get(WebDebugAppender.CURRENT_USER);
        if (currentUser == null)
            currentUser = WebDebugAppender.CURRENT_USER_DEFAULT;
        return currentUser;
    }
}