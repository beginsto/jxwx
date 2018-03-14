package pers.jess.template.app.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.jess.template.app.user.bean.User;
import pers.jess.template.app.user.service.UserService;
import pers.jess.template.exception.ServiceException;
import pers.jess.template.exception.enums.GeneralExceptionEnums;
import sun.rmi.runtime.NewThreadAction;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;
import java.lang.reflect.Method;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(String username){
        if (username == null){
           // Throwable s = new NullPointerException();
        throw new WebServiceException(GeneralExceptionEnums.ERROR_PARAM.toString());
       //    return sr.getMessage();
        }

        return userService.queryUserByUserName("你好").toString();
    }
}
