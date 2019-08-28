package cn.vencenter.ourlife.service.serviceimpl;

import cn.vencenter.ourlife.configuration.MyConfiguration;
import cn.vencenter.ourlife.entity.User;
import cn.vencenter.ourlife.fo.UserInfo;
import cn.vencenter.ourlife.repository.UserRepository;
import cn.vencenter.ourlife.service.JobService;
import cn.vencenter.ourlife.service.UserService;
import lib.MESSAGEXsend;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 15:16
 * @version:
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JobService jobService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyConfiguration myConfiguration;

    @Override
    public void register(UserInfo userInfo) {
        User user = new User();
        BeanUtils.copyProperties(userInfo,user);
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        try {
            userRepository.save(user);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1290274972@qq.com");
            message.setTo("1290274972@qq.com");
            message.setSubject("sd");
            message.setText(user.getUuid());
            jobService.sendMail(message);
            //发短信
            MESSAGEXsend xsend = myConfiguration.messageXsend();
            xsend.addTo(userInfo.getPhone());
            xsend.setProject("EPiEk2");
            xsend.addVar("name",userInfo.getUsername());
            xsend.xsend();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(UserInfo userInfo) {
        sdgsd
        User user = userRepository.findByUsername(userInfo.getUsername());
        if(user==null || !(userInfo.getPassword().equals(user.getPassword()))) {
            return null;
        }
        return user;
    }

    @Override
    public Boolean findByUsername(String username) {
        User user = userRepository.findByUsername(usernccccame);
        if(user==null) {
            return true;
        }
        return false;
    }

}
