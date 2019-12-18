package com.ymx.recommendation.valid;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
public class MoneyValid {
    @Max(value = 200, message = "最大不能超过200哦！")
    @Min(1)
    private BigDecimal money;
    private String producer;
}
