package cn.vencenter.ourlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@EnableAsync
public class OurlifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurlifeApplication.class, args);
    }

}
