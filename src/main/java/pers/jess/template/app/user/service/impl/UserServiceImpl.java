package pers.jess.template.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.jess.template.app.user.bean.User;
import pers.jess.template.app.user.dao.UserDao;
import pers.jess.template.app.user.service.UserService;
import pers.jess.template.exception.ServiceException;
import pers.jess.template.exception.enums.GeneralExceptionEnums;
import pers.jess.template.redis.RedisEvict;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    @RedisEvict(type = User.class)
    public User queryUserByUserName(String username){
        if (username.equals("你好"))
            throw new ServiceException(GeneralExceptionEnums.EMPTY_PARAM.toString());
        return userDao.queryUserByUserName(username);
    }
}
