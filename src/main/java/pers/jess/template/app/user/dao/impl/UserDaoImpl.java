package pers.jess.template.app.user.dao.impl;

import org.springframework.stereotype.Repository;
import pers.jess.template.app.user.bean.User;
import pers.jess.template.app.user.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

    public User queryUserByUserName(String username){
        User user = new User();
        user.setId(1);
        user.setUsername("test");
        return user;
    }

}
