package site.javaee.thymeleaf_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.javaee.thymeleaf_proj.exception.UserNotExistsException;

import java.util.Arrays;
import java.util.Map;

/**
 * @author JunTao
 * @create 2020/4/11 23:51
 */
@Controller
public class HelloController {
    @RequestMapping("/success")
    public String hello(Map<String,Object> map){
        map.put ("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        throw new UserNotExistsException();
        //return "success";
    }
}
