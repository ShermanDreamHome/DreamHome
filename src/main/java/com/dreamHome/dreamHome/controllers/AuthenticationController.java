package com.dreamHome.dreamHome.controllers;

import com.dreamHome.dreamHome.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }


    // do i have a post mapping here to redirect to
    // profile and favorites or in user controller?
}
