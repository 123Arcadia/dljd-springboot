package com.zcw.springboot15swagger.Controller;

import com.zcw.springboot15swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试 Swagger")
//@Tag(name = "测试 Swagger")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @ApiOperation("测试")
//    @Operation(summary = "foo", description = "bar")
    @RequestMapping("/test")
    public String test() {
        User zcw = new User("zcw", "19");
        return "沉默王二又帅 " + zcw;
    }
}
