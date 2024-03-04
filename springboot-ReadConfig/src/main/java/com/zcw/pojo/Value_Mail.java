package com.zcw.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Component
public class Value_Mail {

    @Value("${mail.hostname}")
    private String hostName;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.from}")
    private String from;

    @Value("#{${mail.map}}")
    private Map<String, String> map=new HashMap<>();

    @Value("#{'${mail.list}'.split(',')}")
    private List<String> list=new ArrayList<>();

//    @Value("${mail.recipients}")
//    private List<String> recipients;
//
//    @Value("${mail.headers}")
//    private Map<String, String> headers;

}
