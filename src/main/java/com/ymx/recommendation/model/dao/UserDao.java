package com.ymx.recommendation.model.dao;

import com.ymx.recommendation.model.entity.Luckymoney;
import com.ymx.recommendation.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
}
