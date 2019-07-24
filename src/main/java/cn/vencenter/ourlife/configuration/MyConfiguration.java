package cn.vencenter.ourlife.configuration;

import config.AppConfig;
import lib.MESSAGEXsend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-25 02:18
 * @version:
 **/
@Configuration
public class MyConfiguration {
    @Autowired
    private MessageConfig messageConfig;

    @Bean
    public MESSAGEXsend messageXsend() {
        return new MESSAGEXsend(appConfig());
    }

    @Bean
    public AppConfig appConfig() {
        AppConfig appConfig = new AppConfig();
        appConfig.setAppId(messageConfig.getMsg_appid());
        appConfig.setAppKey(messageConfig.getMsg_appkey());
        appConfig.setSignType(messageConfig.getMsg_signtype());
        return appConfig;
    }

}
