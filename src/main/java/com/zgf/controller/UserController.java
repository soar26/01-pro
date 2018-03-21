package com.zgf.controller;

import com.zgf.dto.AjaxDto;
import com.zgf.dto.StudentDto;
import com.zgf.dto.UserDto;
import com.zgf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView loginPage(ModelAndView mav){
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/checkLogin")
    public UserDto login(@RequestParam("userName") String userName,@RequestParam("password") String password, ModelAndView mav){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("password",password);
        UserDto  user = userService.findUserByUserNameAndPassword(map);
        //System.out.println(user);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        Subject currUser = SecurityUtils.getSubject();
        currUser.login(token);
        System.out.println(currUser.getPrincipal());
        return user;
    }
}
