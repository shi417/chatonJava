package com.gpt.chatgpt.entity.completions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;

public class ChatGptCompletion {

    /**
     * model 型号
     */
    @NonNull
    @Builder.Default
    private String model = Completion.Model.DAVINCI_003.getName();

    /**
     * 问题描述
     */
    @NonNull
    private String prompt;

    /**
     * 最大支持4096
     */
    @JsonProperty("max_tokens")
    @Builder.Default
    private Integer maxTokens = 2048;

    /**
     * 使用什么取样温度，0到2之间。较高的值(如0.8)将使输出更加随机，而较低的值(如0.2)将使输出更加集中和确定。
     * <p>
     * We generally recommend altering this or but not both.top_p
     */
    @Builder.Default
    private double temperature = 0;

    /**
     * 使用温度采样的替代方法称为核心采样，其中模型考虑具有top_p概率质量的令牌的结果。因此，0.1 意味着只考虑包含前 10% 概率质量的代币。
     * <p>
     * 我们通常建议更改此设置，但不要同时更改两者。temperature
     */
    @JsonProperty("top_p")
    @Builder.Default
    private Double topP = 1d;
}
