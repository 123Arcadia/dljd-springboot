package com.zcw.springboot11demo.Controller;


import com.zcw.springboot11demo.Pojo.Person;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api")
@Validated
public class PersonController {

    /**
     * POST http://localhost:8080/api/person1?classId=1&name=zcw&sex=1&email=1119045415
     * @param person
     * @return
     */
    @PostMapping("/person1")
    @ResponseBody
    public String getPerson(@Valid Person person , BindingResult bindingResult) {
        System.out.println("person = " + person);
        System.out.println("error = " + bindingResult.getAllErrors());
        if  (bindingResult.hasErrors())
        {
            System.out.println("error = " + bindingResult.getAllErrors());
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return person.toString() + "调用成功!";
    }


    /**
     * GET http://localhost:8080/api/person?id=1
     *     @PathVariable /person/{id}
     * @param id
     * @return
     */
    @RequestMapping("/person/{id}")
    @ResponseBody
    public String  getPersonByID(@Valid @PathVariable @Max(message = "超过 id 的范围了", value = 5) Integer id, BindingResult result) {
        System.out.println("id = " + id);
        if (result.hasErrors()) {
            System.out.println("id = " + id);
            throw new RuntimeException(result.getAllErrors().get(0).getDefaultMessage());
        }
        System.out.println("========");
        System.out.println( result.getAllErrors());
        System.out.println("--" + result.getAllErrors().get(0));
        return "[id = ]" + id;
    }
}
