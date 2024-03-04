package com.zcw.pojo;

import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@Data
public class PropertiesLoaderUtilsPojo {

    private  String first;
    private  String second;

    /**
     * 改成静态也行
     */
    public void readConfig() {
        try {
            ClassPathResource resource = new ClassPathResource("PropertiesLoaderUtils.properties");
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            first = properties.getProperty("PropertiesLoaderUtils.first", "default_val1");
            second = properties.getProperty("PropertiesLoaderUtils.second", "default_val2");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
