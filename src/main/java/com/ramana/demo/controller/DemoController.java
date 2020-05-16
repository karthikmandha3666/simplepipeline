package com.ramana.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@ComponentScan



@RestController
public class DemoController {

    @RequestMapping("/something")
    public String some(){
        return "helloworld";
    }
}
