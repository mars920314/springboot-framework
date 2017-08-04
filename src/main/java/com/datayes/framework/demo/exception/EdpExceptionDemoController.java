package com.datayes.framework.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datayes.framework.exception.WebserviceCommonExceptions;
import com.datayes.framework.exception.WebserviceException;
import com.datayes.framework.exception.WebserviceValidationException;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/exception")
public class EdpExceptionDemoController {
	Logger logger = LoggerFactory.getLogger(getClass());

    public static class MyException extends RuntimeException{
        public MyException(String message){
            super(message);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/MyException Test", method = RequestMethod.GET)
    public String testException(){
        throw new MyException("Exception Test");
    }

    @ResponseBody
    @RequestMapping(value = "/RrpException", method = RequestMethod.GET)
    public String testRrpException(){
        throw new WebserviceException("RrpException Test");
    }

    @ResponseBody
    @RequestMapping(value = "/CommonExceptions.InternalServerException", method = RequestMethod.GET)
    public String testCommonExceptions_InternalServerException(){
        throw new WebserviceCommonExceptions.ServerInternalException(new Exception("inner exception"));
    }

    @ResponseBody
    @RequestMapping(value = "/RrpValidationException", method = RequestMethod.GET)
    public String testRrpValidationException(){
        Map<String, String> map = new HashMap<>();
        map.put("field1", "message1");
        map.put("field2", "message2");
        throw new WebserviceValidationException(map);
    }
}

