package com.gpt.service;

import com.gpt.annotion.TransLog;
import com.gpt.chatgpt.abs.AbstractClient;
import com.gpt.vo.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TranslateServiceImpl implements ITranslateService {

    private AbstractClient chatGPTClient;

    @Override
    @TransLog
    public String doTranslate(Question question) {

        String text = formatQuestion(question);
        String answer = chatGPTClient.ask(text);
        log.info("chatGPT返回结果:{}", answer);
        return answer;
    }

    private String formatQuestion(Question question) {
        String content = question.getContent();
        content = content.replaceAll("\"", "");
        content = content.replaceAll("“", "");
        return String.format("请用最标准的语法把这句话翻译成%1$s:\"%2$s\"", question.getLanguage(), content);
    }

    @Autowired
    public void setChatGPTClient(AbstractClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }
}
