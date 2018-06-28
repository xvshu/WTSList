package com.xs.java.controllers;

import com.xs.java.model.WebTables;
import com.xs.java.service.WebTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Value("${app.login.username}")
    private String username;

    @Value("${app.login.password}")
    private String password;

    @Autowired
    private WebTablesService webTablesService;


    @RequestMapping("/login")
    public String index(Model model){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
        session.setAttribute("user",false);
        return "login";
    }


    @RequestMapping("/login/check")
    @ResponseBody
    public String check(@RequestParam("userName")String userName, @RequestParam("password")String password,HttpSession session){
        System.out.println("userName:"+userName+" password:"+password);
        System.out.println("sys_userName:"+this.username+" sys_password:"+this.password);
        String result = "fail";
        if(userName!=null && password!=null &&
                userName.equals(this.username) && password.equals(this.password)) {
            session.setAttribute("user",true);
            result = "ok";

        }
        System.out.println(result);
        return result;
    }





}
