package cn.vencenter.ourlife.controller;

import cn.vencenter.ourlife.entity.User;
import cn.vencenter.ourlife.fo.UserInfo;
import cn.vencenter.ourlife.service.JobService;
import cn.vencenter.ourlife.service.UserService;
import cn.vencenter.ourlife.utils.CookieUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 14:48
 * @version:
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MailSender mailSender;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(UserInfo userInfo) {
        try {
            userService.register(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return "commons/fail";
        }
        return "redirect:http://127.0.0.1/";
    }

    @RequestMapping("/login")
    public String login(UserInfo userInfo,HttpServletResponse response) {
        User login = userService.login(userInfo);
        if(login==null) {
            return "commons/fail";
        }
        response.addHeader("token",login.getUuid());
        return "welcome";
    }

    @GetMapping("/uservalidate")
    @ResponseBody
    public Map<String,Boolean> userValidate(@RequestParam("username")String username) {
        HashMap<String, Boolean> map = new HashMap<>();
        if("".equals(username)||username==null) {
            map.put("message",false);
        }
        Boolean aBoolean = userService.findByUsername(username);
        map.put("message",aBoolean);
        return map;
    }

}
