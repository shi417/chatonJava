package com.gpt.chatgpt;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.*;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;
import com.gpt.chatgpt.abs.AbstractClient;
import com.gpt.chatgpt.config.ChatGPTUrl;
import com.gpt.chatgpt.entity.common.Choice;
import com.gpt.chatgpt.entity.completions.Completion;
import com.gpt.chatgpt.entity.completions.CompletionResponse;
import com.gpt.chatgpt.exception.BaseException;
import com.gpt.chatgpt.exception.CommonError;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 描述： chatgpt客户端
 *
 * @author https:www.unfbx.com
 *  2023-02-11
 */
@Getter
@Slf4j
public class ChatGPTClient extends AbstractClient {

    public ChatGPTClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String ask(String question) {
        Completion q = Completion.builder()
                .prompt(question)
                .build();
        HttpRequest header = HttpRequest
                .post(ChatGPTUrl.COMPLETIONS.getUrl())
                .body(JSONObject.from(q).toString())
                .header(Header.AUTHORIZATION.getValue(), "Bearer " + this.apiKey)
                .header(Header.CONTENT_TYPE.getValue(), ContentType.JSON.getValue());
        log.info("调用ChatGPT请求报文：{}",header.toString());
        HttpResponse response = header.execute();
        String body = response.body();
        log.info("调用ChatGPT请求返回值：{}", body);
        if (!response.isOk()) {
            if (response.getStatus() == HttpStatus.HTTP_UNAUTHORIZED) {
                CompletionResponse answer = JSONUtil.toBean(response.body(), CompletionResponse.class);
                throw new BaseException(answer.getError().getMessage());
            }
            throw new BaseException(CommonError.RETRY_ERROR);
        }
        log.info("调用ChatGPT请求返回值：{}", body);
        CompletionResponse answer = JSONUtil.toBean(body, CompletionResponse.class);
        if (Objects.nonNull(answer.getError())) {
            return answer.getError().getMessage();
        }
        List<Choice> choiceList = Arrays.stream(answer.getChoices()).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(choiceList)) {
            throw new BaseException(CommonError.RETRY_ERROR);
        }
        StringBuilder msg = new StringBuilder();
        choiceList.forEach(e -> {
            msg.append(e.getText());
            msg.append("\n");
        });
        return msg.toString();
    }


}
