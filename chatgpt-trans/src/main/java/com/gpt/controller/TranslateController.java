package com.gpt.controller;

import com.gpt.service.ITranslateService;
import com.gpt.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController extends Controller {

    @Autowired
    private ITranslateService translateService;
    @RequestMapping(value ="/translate",produces = "application/json;charset=utf-8")
    public String translate(@RequestBody Question question){
        return  translateService.doTranslate(question);
    }
}
