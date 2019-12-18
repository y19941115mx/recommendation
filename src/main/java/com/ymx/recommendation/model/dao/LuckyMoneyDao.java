package com.ymx.recommendation.model.dao;

import com.ymx.recommendation.model.entity.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckyMoneyDao extends JpaRepository<Luckymoney, Integer> {
}
