package com.zx.springboot.comntroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {



    @RequestMapping({"/","/index.html"})
    public  String  index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public  String  hello(){

        return "Hello SpringBoot";
    }
    @RequestMapping("/success")
    public  String success(Map<String,Object> map){
        map.put("hello","<h1>你好呀<h1>");
        map.put("users", Arrays.asList("zx","dlf","hj","lxk"));
        //转templates下的success.html
        return "success";
    }
}