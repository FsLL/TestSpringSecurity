package com.lqj.controller;

import com.lqj.dto.LoginUser;
import com.lqj.dto.ResponseResult;
import com.lqj.entity.User;
import com.lqj.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * @Author lqj
 * @Date 2022-10-24 14:39
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }

    @RequestMapping("/demo")
    public ModelAndView demo(){
        User user = new User();
        user.setUserName("zhangsan");
        user.setPhonenumber("18049445186");
        LoginUser loginUser = new LoginUser();
        ArrayList<String> list = new ArrayList<>();
        list.add("insert");
        list.add("select");

        loginUser.setPermissions(list);
        loginUser.setUser(user);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return new ModelAndView("demo");
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return loginServcie.logout();
    }

}
