package com.zcw.springboot12druid.pojo;

import lombok.Data;
import lombok.ToString;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
