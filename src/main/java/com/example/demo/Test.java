package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
    @RequestMapping("/hello")
    @ResponseBody
    public String wyswietl(){
        return "helloworld.html";
    }

    @RequestMapping ("/hello2")
    public String wyswietl2(){
        return "helloworld2.html";
    }
}
