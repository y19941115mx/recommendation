package com.ymx.recommendation.valid;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
public class MoneyValid {
    @Max(value = 200, message = "最大不能超过200哦！")
    @Min(1)
    @NotNull
    private BigDecimal money;
    @NotBlank
    private String producer;
}
