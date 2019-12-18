package com.ymx.recommendation.service.impl;

import com.ymx.recommendation.model.dao.LuckyMoneyDao;
import com.ymx.recommendation.model.entity.Luckymoney;
import com.ymx.recommendation.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class LuckymoneyServiceImpl implements LuckymoneyService {

    @Autowired
    private LuckyMoneyDao luckyMoneyDao;

    @Override
    public List<Luckymoney> getList() {
        return luckyMoneyDao.findAll();
    }

    @Override
    public Luckymoney add(String producer, BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return  luckyMoneyDao.save(luckymoney);
    }


    @Override
    public Luckymoney update(int id, String consumer) {
        Optional<Luckymoney> optional = luckyMoneyDao.findById(id);

        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return luckyMoneyDao.save(luckymoney);
        }

        return null;
    }

    @Override
    public Luckymoney get(int id) {
        return luckyMoneyDao.findById(id).orElse(null);
    }
}
