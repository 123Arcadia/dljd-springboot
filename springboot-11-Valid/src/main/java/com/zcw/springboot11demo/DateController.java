package com.zcw.springboot11demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/api")
public class DateController {
    @RequestMapping("/dateparam")
    @ResponseBody
    public String paramDate(Date date) {
        System.out.println("date = " + date);
        return "{module}: " + date;
    }

    @RequestMapping("/dateparam1")
    @ResponseBody
    public String paramDate1(Date date1, @DateTimeFormat(pattern ="yyyy/MM/dd HH:mm:ss") Date date2) {
        System.out.println("date1 = " + date1);
        System.out.println("date1 = " + date2);
        return "{module}: " + date1 + "-> date2 = " + date2;
    }
}
