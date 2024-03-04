package com.zcw.demomp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.zcw.demomp.EnumsEntity.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(autoResultMap = true, value = "user_copy1")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private String address;

    /**
     * 默认值：1
     * 删除值：0
     */
    @TableLogic(value = "1", delval = "0")
    private Integer status;

    @TableField("gender")
    private GenderEnum genderEnum;

    @Version
    @TableField(exist = false)
    private Integer version;

    /**
     * 字段处理器: 在MySQL中存储为json格式
     * FastjsonTypeHandler: 依赖一个fastjson依赖项
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String, String> concat;


    /**
     * 数据库user_copy1中是下划线形式，程序里是驼峰形式
     * 需要在yml配置：
     * configuration:
     *     map-underscore-to-camel-case: true
     */

    /**
     * 表示插入时修改时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 表示插入、更新时修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
