package site.javaee.thymeleaf_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author JunTao
 * @create 2020/4/13 0:08
 */
@Controller
public class LoginController {
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    //@GetMapping
    //@DeleteMapping
    //@PutMapping
    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功！防止刷新时表单重复提交，进行重定向
            session.setAttribute("loginUser",username);
            return "redirect:/dashboard.html";

        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }

    }
}
