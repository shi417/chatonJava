package com.gpt.service;

import com.gpt.vo.Question;

public interface ITranslateService {
    String doTranslate(Question question);
}
