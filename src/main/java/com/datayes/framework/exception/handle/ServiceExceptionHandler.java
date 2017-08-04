package com.datayes.framework.exception.handle;

import com.datayes.framework.exception.WebserviceException;
import com.datayes.framework.exception.WebserviceValidationException;
import com.datayes.framework.exception.handle.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Webservice系列错误截处理器，返回Webservice标准错误格式数据
 */
@ControllerAdvice
public class ServiceExceptionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(WebserviceException.class)
    public ResponseEntity<ServiceExceptionResponse> handle(HttpServletRequest request, HttpServletResponse response, WebserviceException ex) {
        logger.debug("[exception:WebserviceException] handled: {}", ex);
        ServiceExceptionResponse body = new ServiceExceptionResponse();
        String requestId = ExceptionUtil.getRequestId(request, response, ex.getRequestId());
        body.setRequestId(requestId);
        body.setCode(ex.getCode());
        body.setMessage(ex.getMessage());
        logger.info("[exception] [status:{},code:{}] {} {}", ex.getHttpStatus(), body.getCode(), request.getMethod(), request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getHttpStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceExceptionResponse> handle(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        logger.error("[exception:UnknownException] " + request.getMethod() + " " + request.getRequestURI(), ex);
        ServiceExceptionResponse body = new ServiceExceptionResponse();
        String requestId = ExceptionUtil.getRequestId(request, response, null);
        body.setRequestId(requestId);
        body.setCode("Exception");
        body.setMessage("Internal Server Error");
        logger.info("[exception:{}] {} {}", body.getCode(), request.getMethod(), request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WebserviceValidationException.class)
    public ResponseEntity<ServiceExceptionResponse> handle(HttpServletRequest request, HttpServletResponse response, WebserviceValidationException ex) {
        logger.debug("[exception:WebserviceValidationException] handled: {}", ex);
        ServiceExceptionResponse body = new ServiceExceptionResponse();
        String requestId = ExceptionUtil.getRequestId(request, response, ex.getRequestId());
        body.setRequestId(requestId);
        body.setCode(ex.getCode());
        body.setMessage(convertFiledMessageMapToString(ex));
        logger.info("[exception:{}] {} {}", body.getCode(), request.getMethod(), request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getHttpStatus()));
    }

    private String convertFiledMessageMapToString(WebserviceValidationException ex) {
        StringBuilder message = new StringBuilder();
        for (Map.Entry<String, String> fieldMessage : ex.getFieldMessageMap().entrySet()) {
            message.append(fieldMessage.getKey()).append(":").append(fieldMessage).append('\n');
        }
        return message.toString();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServiceExceptionResponse> handle(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException ex) {
        return handle(request, response, new WebserviceValidationException(ex.getBindingResult()));
    }

}
