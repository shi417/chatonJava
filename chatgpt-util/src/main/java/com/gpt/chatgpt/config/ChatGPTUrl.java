package com.gpt.chatgpt.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 描述： api地址
 *
 * @author https:www.unfbx.com
 *  2023-02-11
 */
@Getter
@AllArgsConstructor
public enum ChatGPTUrl {

    COMPLETIONS("https://api.openai.com/v1/completions"),

    COMPLETIONS_CHAT("https://api.openai.com/v1/chat/completions");
    private String url;

}
