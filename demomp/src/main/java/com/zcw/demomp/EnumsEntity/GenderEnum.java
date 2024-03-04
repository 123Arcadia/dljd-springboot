package com.zcw.demomp.EnumsEntity;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 性别
 * @author zhangchenwei
 */
public enum GenderEnum {
    MAN(1, "男"), WOMAN(0, "女");

    /**
     * 表示枚举类对应数据库中的值
     */
    @EnumValue
    private Integer gender;
    private String genderName;

    GenderEnum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }
}
