package cn.vencenter.ourlife.service;

import cn.vencenter.ourlife.entity.User;
import cn.vencenter.ourlife.fo.UserInfo;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 15:14
 * @version:
 **/
public interface UserService {
    void register(UserInfo userInfo);
    User login(UserInfo userInfo);

    Boolean findByUsername(String username);
}
