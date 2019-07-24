package cn.vencenter.ourlife.repository;

import cn.vencenter.ourlife.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-23 15:19
 * @version:
 **/
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
