package com.gpt.chatgpt.abs;


public abstract class AbstractClient {
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String apiKey;

    public abstract String ask(String question);
}
