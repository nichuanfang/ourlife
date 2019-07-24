package cn.vencenter.ourlife.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-25 02:15
 * @version:
 **/
@ConfigurationProperties(prefix = "msg")
@Data
@Component
public class MessageConfig {
    private String msg_appid;
    private String msg_appkey;
    private String msg_signtype;
}
