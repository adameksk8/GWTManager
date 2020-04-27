package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Colors {
String color="Blue";
    public Colors(){

    }

    @RequestMapping("/colors")
    public String getColors(Model model){

        model.addAttribute("color",color);
        model.addAttribute("hello", "Witaj świecie!");
        return "colors.html";

    }
}
