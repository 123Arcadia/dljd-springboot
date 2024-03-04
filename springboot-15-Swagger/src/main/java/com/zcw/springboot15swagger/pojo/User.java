package com.zcw.springboot15swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("model类")
public class User {
    @ApiModelProperty("name名字")
    private String name;
    @ApiModelProperty("age年龄")
    private String age;


}
