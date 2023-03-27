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
        String text  = String.format("请将 %1$s 翻译成 %2$s",question.getContent(),question.getLanguage());
        String answer = chatGPTClient.ask(text);
        log.info("chatGPT返回结果:{}",answer);
        return answer;
    }

    @Autowired
    public void setChatGPTClient(AbstractClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }
}
