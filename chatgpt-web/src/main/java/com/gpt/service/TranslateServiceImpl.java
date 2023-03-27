package com.gpt.service;

import com.gpt.annotion.TransLog;
import com.gpt.chatgpt.abs.AbstractClient;
import com.gpt.vo.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TranslateServiceImpl implements ITranslateService{

    private AbstractClient chatGPTClient;

    @Override
    @TransLog
    public String doTranslate(Question question) {
        String text  = String.format("请把我这句话翻译成%1$s:\"%2$s\"",question.getLanguage(),question.getContent());
        String answer = chatGPTClient.ask(text);
        log.info("chatGPT返回结果:{}",answer);
        return answer;
    }

    @Autowired
    public void setChatGPTClient(AbstractClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }
}
