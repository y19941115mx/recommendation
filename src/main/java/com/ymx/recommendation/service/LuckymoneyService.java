package com.ymx.recommendation.service;

import com.ymx.recommendation.model.entity.Luckymoney;

import java.math.BigDecimal;
import java.util.List;

public interface LuckymoneyService {
    /***
     * 获取红包列表
     */
    List<Luckymoney> getList();

    /***
     * 添加红包
     */
    Luckymoney add(String producer,BigDecimal money);

    /***
     * 更新红包
     */
    Luckymoney update(int id, String consumer);

    /***
     * 根据id获取红包
     */
    Luckymoney get(int id);


}
