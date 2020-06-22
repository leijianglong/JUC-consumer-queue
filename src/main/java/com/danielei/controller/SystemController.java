package com.danielei.controller;

import com.danielei.entity.User;
import com.danielei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * date: 2020/6/22 0022
 **/
@RequestMapping("/system")
@Controller
public class SystemController {

    @Autowired
    UserService userService;

    @GetMapping("/{path}")
    public String index(@PathVariable  String path){
        return path;
    }

    @ResponseBody
    @PostMapping("/register")
    public Map register(User user){
        Map resultMap = new HashMap();
        userService.register(user);
        return resultMap;
    }
}
