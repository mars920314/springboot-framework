package mars.framework.logging;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Created by zhangzheyuan on 2014/7/29.
 */
public class WebDebugAppender extends AppenderBase<ILoggingEvent> {

    public static final String CURRENT_USER = "currentUser";
    public static final String CURRENT_USER_DEFAULT = "AllUser";

    private static PatternLayoutEncoder encoder;
    private static Map<String, PatternLayoutEncoder> userEncoderMap = new ConcurrentHashMap<>();

    public static void addWebLog(String userName, OutputStream stream) throws IOException {
        PatternLayoutEncoder userEncoder = new PatternLayoutEncoder();
        userEncoder.setContext(encoder.getContext());
        userEncoder.setCharset(encoder.getCharset());
        userEncoder.setPattern(encoder.getPattern());
        userEncoder.setImmediateFlush(true);
        try {
            userEncoder.init(stream);
            userEncoder.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        userEncoderMap.put(userName, userEncoder);
    }

    @Override
    public void start() {
        if (this.encoder == null) {
            addError("No encoder set for the appender named ["+ name +"].");
            return;
        }

        super.start();
    }

    public void append(ILoggingEvent event) {
//        if (event.getLevel().levelInt < Level.INFO_INT)
//            return;

        String currentUser = getCurrentUser(event);
        PatternLayoutEncoder encoder = userEncoderMap.get(currentUser);
        if (encoder == null)
            return;

        try {
            encoder.doEncode(event);
        } catch (IOException e) {
            encoder.stop();
            userEncoderMap.remove(currentUser);
        }
    }

    private String getCurrentUser(ILoggingEvent event) {
        String currentUser = event.getMDCPropertyMap().get(CURRENT_USER);
        if (currentUser == null)
            currentUser = CURRENT_USER_DEFAULT;
        return currentUser;
    }

    public PatternLayoutEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(PatternLayoutEncoder encoder) {
        this.encoder = encoder;
    }
}