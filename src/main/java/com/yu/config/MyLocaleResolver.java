package com.yu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/24 12:54
 */

@Component
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 接收语言的参数 - 传进来的就是形如'zh_CN'这样的参数
        String lan = request.getParameter("l");
        // 使用默认的语言 - 在文中就是login.properties文件里配置的
        Locale locale = Locale.getDefault();
        // 判断接收的参数是否为空，不为空就设置为该语言
        if(lan!=null){
            // 将参数分隔 - 假设传进来的是'zh_CN'
            String[] s = lan.split("_");
            // 语言编码:zh   地区编码:CN
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

}

