package site.javaee.thymeleaf_proj.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author JunTao
 * @create 2020/4/12 23:50
 * 国际化信息处理
 */
public class MyLocaleResolver  implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l) ){
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }else{
            //locale = new Locale("en", "US");
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
