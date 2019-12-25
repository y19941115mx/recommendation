package com.ymx.recommendation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limit")
@Data
public class LimitConfig {
    private int maxMoney;
    private int minMoney;
}
