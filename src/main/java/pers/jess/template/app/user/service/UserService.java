package pers.jess.template.app.user.service;

import pers.jess.template.app.user.bean.User;

public interface UserService {

    User queryUserByUserName(String username);
}
