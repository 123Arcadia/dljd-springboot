package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/getmapping/{userId}")
    public String test_Get(@PathVariable("userId") Integer id) {
        return "test_Get (user):" + id;
    }


}
