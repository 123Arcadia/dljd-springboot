package com.zcw.springannoationdemo.TestDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public String Name;
    public String Age;
    /**
     * 想要使校验起作用就得在参数头上加上 @Vaild 否则校验不起作用
     *
     * 注意: 一般是在Http请求来验证参数，单纯验证无效
     */
    @Valid
    @Size(message = "数字在1-27之间", min = 1, max = 27)
    public Integer Number;
}
