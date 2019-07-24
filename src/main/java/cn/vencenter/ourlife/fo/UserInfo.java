package cn.vencenter.ourlife.fo;

import lombok.Data;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 15:09
 * @version:
 **/
@Data
public class UserInfo {
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**手机号*/
    private String phone;
    /**电子邮箱*/
    private String email;
}
