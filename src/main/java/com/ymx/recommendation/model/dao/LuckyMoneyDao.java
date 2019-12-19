package com.ymx.recommendation.model.dao;

import com.ymx.recommendation.model.entity.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuckyMoneyDao extends JpaRepository<Luckymoney, Integer> {
}
