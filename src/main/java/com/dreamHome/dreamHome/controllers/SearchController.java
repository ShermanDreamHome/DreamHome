package com.dreamHome.dreamHome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String searchView() {
        return "search";
    }


    @PostMapping("/search/{id}")
    public String search(@PathVariable String id) {
        return "search";
    }

}
