package com.zcw.springbootexceptionhandlertest.Controller;


import com.zcw.springbootexceptionhandlertest.ExceptionCase.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/1")
    public void throwException1() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/2")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }
}
