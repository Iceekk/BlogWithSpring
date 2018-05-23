package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThemeController {

    @GetMapping("/theme")
    public String themeTest(){
        return "theme-reworked/base-layout";
    }
}
