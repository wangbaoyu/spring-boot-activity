package com.activity.demo.controller;

import com.activity.demo.domain.User;
import com.activity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    public ModelAndView selectUserByUserId(@RequestParam Map<String,Object> map){
        User user = userService.selectUserByUserId(map.get("userId").toString());
        ModelAndView  modelAndView= new ModelAndView("index");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
