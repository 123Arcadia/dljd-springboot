package com.zcw.springboot14redis.Controller;

import com.zcw.springboot14redis.pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class redisController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/myname")
    public String getName() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // redisTemplate.setValueSerializer( new StringRedisSerializer());
        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }

    @PostMapping("/name/{myname}")
    public String addName(@PathVariable("myname") String name) {
        redisTemplate.opsForValue().set("name", name);
        redisTemplate.opsForValue().set("name", name);
        return "添加了: " + name;
    }

    /**
     * 使json序列化， ba java对象转成json存储
     */
    @PostMapping("/addjson")
    public String addJson() {
        Student student = new Student("zzz", 1, 19);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //把值作为json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        redisTemplate.opsForValue().set("mystuent", student);
        return "json序列化!";
    }

}
