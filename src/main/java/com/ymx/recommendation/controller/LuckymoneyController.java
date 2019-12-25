package com.ymx.recommendation.controller;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ymx.recommendation.common.BasicAuthedController;
import com.ymx.recommendation.common.CommonException;
import com.ymx.recommendation.common.CommonRes;
import com.ymx.recommendation.model.entity.Luckymoney;
import com.ymx.recommendation.model.entity.QLuckymoney;
import com.ymx.recommendation.service.LuckymoneyService;
import com.ymx.recommendation.valid.MoneyValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/luckymoney")
public class LuckymoneyController extends BasicAuthedController {

    @Autowired
    private LuckymoneyService luckymoneyService;

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/test")
    public CommonRes test() throws CommonException {
        QLuckymoney luckymoney = QLuckymoney.luckymoney;
        BooleanBuilder builder = new BooleanBuilder();
        //like
        builder.and(luckymoney.producer.like('%' + "v" + '%'));
        builder.and(luckymoney.money.between(0, 50));
        List<Luckymoney> luckymonies = queryFactory.selectFrom(luckymoney).where(builder).fetch();
        httpServletRequest.getSession().setAttribute("current_user", "123");
        return CommonRes.success(getCurrentUserId());
//        throw new CommonException(ErrorEnum.TEST_ERR);
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
    public Luckymoney updata(@PathVariable("id") int id, @RequestParam("consumer") String consumer) {
        return luckymoneyService.update(id, consumer);
    }

    @PostMapping(value = "")
    public Luckymoney add(@Validated @RequestBody MoneyValid moneyValid) {
        return luckymoneyService.add(moneyValid.getProducer(), moneyValid.getMoney());
    }
}
