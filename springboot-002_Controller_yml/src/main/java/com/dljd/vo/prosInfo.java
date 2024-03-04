package com.dljd.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "school") // 找到pros.properties的school开头的数据,school.name
public class prosInfo {

    private String school_name;
    private String school_website;



    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_website() {
        return school_website;
    }

    public void setSchool_website(String school_website) {
        this.school_website = school_website;
    }

    @Override
    public String toString() {
        return "prosInfo{" +
                "school_name='" + school_name + '\'' +
                ", school_website='" + school_website + '\'' +
                '}';
    }
}
