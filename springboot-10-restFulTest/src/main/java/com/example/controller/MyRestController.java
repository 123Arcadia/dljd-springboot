package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {
    @GetMapping("/getMapping/{userId}")
    public String get_test(@PathVariable("userId") Integer id) {
        return "返回id:"  + id;
    }

    /**
     * rest 中， url 要使用占位符，表示传递的数据。
     * 占位符叫做路径变量， 在 url 中的数据
     *
     * 格式： 在@RequestMapping 的 value 属性值中，使用 {自定义名称}
     * http://localhost:8080/myboot/student/1001/bj2009
     *
     *
     * @PathVariable: 路径变量注解，作用是获取 url 中的路径变量的值
     * 属性： value ： 路径变量名称
     * 位置： 在逐个接收参数中，在形参定义的前面
     *
     * @RequestParam: 用于获取查询参数
     *
     * 注意：路径变量名和形参名一样， value 可以不写
     *
     */
    @GetMapping(value = "/student/{studentId}/{classname}")
    public String queryStudent(@PathVariable(value = "studentId") Integer id,
                               @PathVariable String classname){
        return "get 请求，查询学生 studentId："+id+", 班级："+classname;
    }
    ///student/1001/bjpowernode
    @GetMapping(value = "/student/{studentId}/school/{schoolname}")
    public String queryStudentBySchool(@PathVariable(value = "studentId")
                                       Integer id,
                                       @PathVariable String schoolname){
        return "get 请求，查询学生 studentId："+id+", 班级："+schoolname;
    }

    @PostMapping("/student/{stuId}")
    public String createStudent(@PathVariable("stuId") Integer id,
                                String name,
                                Integer age){
        return "post 创建学生， id="+id+",name="+name+",age="+age;
    }

    @PutMapping("/studentput/{stuId}")
    public String modifyStudent(@PathVariable("stuId") Integer id,
                                @RequestBody  String name){
        System.out.println("===========put 请求方式 ========");
        System.out.println("put 修改学生， id="+id+",修改的名称是："+name);
        return "put 修改学生， id="+id+",修改的名称是："+name;
    }

    @DeleteMapping("/studentdelete/{stuId}")
    public String removeStudent(@PathVariable("stuId") Integer id){
        System.out.println("===========delete 请求方式 ========");
        return "delete 删除学生，id="+id;
    }
}

