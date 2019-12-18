package com.ymx.recommendation.controller;

import com.ymx.recommendation.common.CommonException;
import com.ymx.recommendation.common.CommonRes;
import com.ymx.recommendation.common.ErrorEnum;
import com.ymx.recommendation.model.entity.Luckymoney;
import com.ymx.recommendation.service.LuckymoneyService;
import com.ymx.recommendation.config.LimitConfig;
import com.ymx.recommendation.valid.MoneyValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/luckymoney")
public class LuckymoneyController {

    @Autowired
    private LuckymoneyService luckymoneyService;

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/test")
    public String test() throws CommonException {
//        return String.format("max:%d, min:%d", limitConfig.getMaxMoney(), limitConfig.getMinMoney());
        throw new CommonException(ErrorEnum.TEST_ERR);
    }

    @GetMapping("/list")
    public CommonRes list() {
        return CommonRes.success(luckymoneyService.getList());
    }

    @GetMapping("/{id}")
    public Luckymoney get(@PathVariable("id") int id) {
        return luckymoneyService.get(id);
    }

    @PutMapping("/{id}")
    public Luckymoney updata(@PathVariable("id") int id, @RequestParam("consumer") String  consumer) {
        return luckymoneyService.update(id, consumer);
    }

    @PostMapping("")
    public Luckymoney add(@Valid MoneyValid moneyValid) {
        return luckymoneyService.add(moneyValid.getProducer(), moneyValid.getMoney());
    }
}
