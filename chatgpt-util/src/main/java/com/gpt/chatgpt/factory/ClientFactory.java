package com.gpt.chatgpt.factory;

import com.gpt.chatgpt.abs.AbstractClient;
import com.gpt.chatgpt.ChatGPTClient;

public class ClientFactory {

    public static AbstractClient getChatGptClient(String apiKey){
        return new ChatGPTClient(apiKey);
    }

}
