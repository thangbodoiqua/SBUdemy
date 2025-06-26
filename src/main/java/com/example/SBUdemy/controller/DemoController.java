package com.example.SBUdemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {
    @GetMapping("/")
    public String showHome() {

        return "home";
    }
    @GetMapping("/leaders")
    public String showLeaders() {

        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystems() {

        return "systems";
    }



}
