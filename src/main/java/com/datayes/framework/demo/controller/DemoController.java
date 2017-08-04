package com.datayes.framework.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datayes.framework.common.Result;
import com.datayes.framework.common.ResultHelper;
import com.datayes.framework.demo.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {
	Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DemoService demoService;
    
    @ResponseBody
    @RequestMapping(value="/getUpperCase", method = RequestMethod.GET)
    public Result getUpperCase(@RequestParam("word") String word) {
        logger.info("get uppercase for {}", word);
        return ResultHelper.dataToResult(demoService.getUpperCase(word));
    }

    @ResponseBody
    @RequestMapping(value="/getNews", method = RequestMethod.GET)
    public Result getNews(@RequestParam("newsId") Long newsId) {
        logger.info("get news title for newsId {}", newsId);
        return ResultHelper.dataToResult(demoService.getNewsTitleByNewsId(newsId));
    }
    
}
