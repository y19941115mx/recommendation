package com.ymx.recommendation.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal money;

    private String producer;

    private String consumer;
}
