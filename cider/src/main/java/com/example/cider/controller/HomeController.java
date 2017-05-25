package com.example.cider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paul.hilsen on 5/25/2017.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "This is awesome";
    }

}
