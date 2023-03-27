package com.gpt.config;

//import com.gpt.aspect.TransLogAspect;
//import com.gpt.chatgpt.abs.AbstractClient;
//import com.gpt.chatgpt.factory.ClientFactory;
import com.gpt.chatgpt.abs.AbstractClient;
import com.gpt.chatgpt.factory.ClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({TransLogAspect.class})
public class Config {

    @Value("${gpt.appid}")
    public String apiKey;

    @Bean
    public AbstractClient chatGPTClient(){
        return ClientFactory.getChatGptClient(apiKey);
    }
}
