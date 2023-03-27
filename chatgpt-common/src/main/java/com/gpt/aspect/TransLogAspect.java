package com.gpt.aspect;

import com.gpt.holder.RequestHolder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TransLogAspect {
    @Pointcut("@annotation(com.gpt.annotion.TransLog)")
    public void loggable() {}

    @Before("loggable()")
    public void beforeAdvice() {
        HttpServletRequest request = RequestHolder.get();
        String remoteHost = request.getRemoteHost();
        log.info("客户端进行翻译查询:{}",remoteHost);
    }
}
