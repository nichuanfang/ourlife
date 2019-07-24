package cn.vencenter.ourlife.utils;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 23:06
 * @version:
 **/
public class CookieUtils {

    public static Map<String, Cookie> getCooiekMap(Cookie[] cookies) {
        if(cookies.length==0) {
            return null;
        }
        HashMap<String, Cookie> map = new HashMap<>();
        ArrayList<Cookie> list = new ArrayList<>(Arrays.asList(cookies));
        list.forEach(e->{
            map.put(e.getName(),e);
        });
        return map;
    }

    public static Cookie getCookie(String cookiename,Cookie[] cookies) {
        if(cookies.length==0) {
            return null;
        }
        Map<String, Cookie> map = getCooiekMap(cookies);
        Cookie cookie = map.get(cookiename);
        return cookie;
    }
}
