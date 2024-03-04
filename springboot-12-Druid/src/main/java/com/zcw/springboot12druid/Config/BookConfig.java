package com.zcw.springboot12druid.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

@Controller
@PropertySource("classpath:application.yml")
@ComponentScan({"com.zcw."})
public class BookConfig {
}
