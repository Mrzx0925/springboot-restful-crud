package com.zx.springboot.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver{
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String s = request.getParameter("s");
        Locale locale = Locale.getDefault();
        //System.out.println(s);
        if(!StringUtils.isEmpty(s)){
             String spilt[]=  s.split("-");
              //语言代码，以及语言国家
               //System.out.println(spilt[0]+"   "+spilt[1]);
                locale = new Locale(spilt[0],spilt[1]);
        }

        return locale;
    }
}
