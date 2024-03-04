package com.zcw.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *  @ConfigurationProperties 是读取一组配置项的
 */
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class User_ConfigurationProperties {
    private String name;
    private String age;
    private Integer id;


    @DurationUnit(ChronoUnit.SECONDS)
    private Duration duration;


    /**
     * 设置以 MB 为单位
     *     BYTES("B", DataSize.ofBytes(1L)),
     *     KILOBYTES("KB", DataSize.ofKilobytes(1L)),
     *     MEGABYTES("MB", DataSize.ofMegabytes(1L)),
     *     GIGABYTES("GB", DataSize.ofGigabytes(1L)),
     *     TERABYTES("TB", DataSize.ofTerabytes(1L));
     */
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize fileSize;

    /**
     * 也可以参加校验类上加上@Vaildated
     */


    /**
     * 使用 @ConfigurationProperties 注解读取对应配置到新建的 Bean 对象中
     */

    private List<String> list = new ArrayList<>();

    private Map<String, String > map = new HashMap<>();
//    private Map<String, String > map2 = new HashMap<>();


}
