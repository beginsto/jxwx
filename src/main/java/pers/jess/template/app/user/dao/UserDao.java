package pers.jess.template.app.user.dao;

import pers.jess.template.app.user.bean.User;

public interface UserDao {

    User queryUserByUserName(String username);
}
