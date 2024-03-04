package com.zcw.springboot11demo.Pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Dates {
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date date1;
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date date2;
}
