package com.zcw.springboot11demo.Controller;

import com.zcw.springboot11demo.Pojo.Dates;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;


@Controller
@RequestMapping("/api")
public class DateController {
    @PostMapping("/dateparam")
    @ResponseBody
    public String paramDate(Date date) {
        System.out.println("date = " + date);
        return "{module}: " + date;
    }

//    @PostMapping(value = "/dateparam1", params = {"date1","date2"})
    @PostMapping(value = "/dateparam1")
    @ResponseBody
    public String paramDate1(@DateTimeFormat(pattern ="yyyy/MM/dd HH:mm:ss") Date date1, @DateTimeFormat(pattern ="yyyy/MM/dd HH:mm:ss") Date date2) {
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        return "{module}: " + date1 + "-> date2 = " + date2;
    }

    @PostMapping(value = "/date2")
    @ResponseBody
    public String paramDate1(@RequestBody Dates dates) {
        System.out.println("dates = " + dates);
//        return "{module}: " + dates;
        return "/index.html";
    }
}
