package com.dreamHome.dreamHome.controllers;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/hero")
    public String home(){
        return "hero";
    }

    @PostMapping("/hero")
    public String goHome () {
        return "hero";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/user/profile")
    public String userProfile() {
        return "profileUser";
    }

    @GetMapping("/admin/profile")
    public String adminProfile() {
        return "profileAdmin";
    }


}
