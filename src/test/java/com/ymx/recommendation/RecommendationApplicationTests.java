package com.ymx.recommendation;

import com.ymx.recommendation.model.dao.UserDao;
import com.ymx.recommendation.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecommendationApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        User user = new User();
        user.setPhone("17688888888");
        user.setNick_name("victor");
        user.setPassword("123");
        userDao.save(user);
    }

}
