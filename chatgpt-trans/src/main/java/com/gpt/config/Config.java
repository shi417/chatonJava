package com.gpt.config;

//import com.gpt.aspect.TransLogAspect;
//import com.gpt.chatgpt.abs.AbstractClient;
//import com.gpt.chatgpt.factory.ClientFactory;
import com.gpt.chatgpt.abs.AbstractClient;
import com.gpt.chatgpt.factory.ClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@Import({TransLogAspect.class})
public class Config {

    @Value("${gpt.appid}")
    public String apiKey;

    @Bean
    public AbstractClient chatGPTClient() {
        return ClientFactory.getChatGptClient(apiKey);
    }



}
