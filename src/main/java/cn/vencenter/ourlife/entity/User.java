package cn.vencenter.ourlife.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 15:12
 * @version:
 **/
@Data
@Entity
public class User {
    @Id
    private String uuid;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**手机号*/
    private String phone;
    /**电子邮箱*/
    private String email;
}
