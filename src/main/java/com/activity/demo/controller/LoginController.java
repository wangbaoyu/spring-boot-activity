package com.activity.demo.controller;

import com.activity.demo.domain.User;
import com.activity.demo.service.UserService;
import com.activity.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        //ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("goRegister")
    public ModelAndView goRegister(){
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "user/login",method = RequestMethod.GET)
    public JsonResult login(@RequestParam Map<String,Object> map,HttpServletRequest request, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();
        User user = userService.userLogin(map);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return jsonResult.putSuccess("index");
        } else {
            jsonResult.putFailed("用户名或者密码错误！");
            return jsonResult;
        }
    }

    @RequestMapping(value = "user/logout",method = RequestMethod.POST)
    public JsonResult logout(HttpServletRequest request){
        JsonResult js = new JsonResult();
        HttpSession session = request.getSession();
        if(!StringUtils.isEmpty(session.getAttribute("user"))){
            session.removeAttribute("user");
        }
        return js.putSuccess();
    }

    @RequestMapping(value = "user/regist")
    public JsonResult regist(@RequestParam Map<String,Object> map){
        JsonResult jr = new JsonResult();
        String userName = map.get("userName").toString();
        String passWord = map.get("passWord").toString();
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        userService.register(user);
        return jr.putSuccess();
    }
}
