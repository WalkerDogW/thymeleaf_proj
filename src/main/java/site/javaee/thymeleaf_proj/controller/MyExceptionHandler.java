package site.javaee.thymeleaf_proj.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.javaee.thymeleaf_proj.exception.UserNotExistsException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tao
 * @create 2020/4/15 20:24
 */
@ControllerAdvice
public class MyExceptionHandler  {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistsException.class)
//    public Map<String,Object> handleException(Exception e){
//        Map map = new HashMap<String,String>();
//        map.put("code","user.noexist");
//        map.put("message",e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistsException.class)
    public String handleException(Exception e, HttpServletRequest request)   {
        Map map = new HashMap<String, String>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.noexist");
        map.put("message", e.getMessage());
        return "forward:/error";
    }
}
