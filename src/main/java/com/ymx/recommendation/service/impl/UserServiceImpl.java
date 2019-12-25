package com.ymx.recommendation.service.impl;

import com.ymx.recommendation.common.CommonException;
import com.ymx.recommendation.common.CommonUtil;
import com.ymx.recommendation.common.ErrorEnum;
import com.ymx.recommendation.common.JwtHelper;
import com.ymx.recommendation.model.dao.UserDao;
import com.ymx.recommendation.model.entity.QUser;
import com.ymx.recommendation.model.entity.User;
import com.ymx.recommendation.service.UserService;
import com.ymx.recommendation.valid.LoginValid;
import com.ymx.recommendation.valid.RegisterValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: recommendation
 * @description: 用户服务
 * @author: victor
 * @create: 2019-12-25 16:37
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    JwtHelper jwtHelper;

    @Override
    public String login(LoginValid loginValid) throws CommonException {
        // 根据电话号码查询用户
        String phone = loginValid.getPhone();
        String pass = CommonUtil.md5Encode(loginValid.getPassword());

        Optional<User> one = getUser(phone);

        // 匹配密码
        if (one.isPresent() && one.get().getPassword().equals(pass)) {
            return jwtHelper.sign(one.get().getId());
        } else {
            throw new CommonException(ErrorEnum.LOGIN_FALIED);
        }
    }

    /**
     * 根据电话号码获取用户
     * @param phone 电话号码
     * @return Optional user
     */
    private Optional<User> getUser(String phone) {
        QUser user = QUser.user;
        return userDao.findOne(user.phone.eq(phone));
    }

    @Override
    public User register(RegisterValid registerValid) throws CommonException{
        // 检查电话号码是否存在
        Optional<User> user = getUser(registerValid.getPhone());
        if (user.isPresent()) {
            throw new CommonException(ErrorEnum.PHONE_DUPLICATED);
        } else {
            // 添加用户
            User newUser = new User();
            newUser.setNickName(registerValid.getNickName());
            // 加密后存储
            newUser.setPassword(CommonUtil.md5Encode(registerValid.getPassword()));
            newUser.setPhone(registerValid.getPhone());
            newUser.setGender(registerValid.getGender());
            return userDao.save(newUser);
        }
    }
}
