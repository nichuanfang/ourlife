package cn.vencenter.ourlife;
import cn.vencenter.ourlife.job.MyJob;
import com.google.common.collect.Lists;

import cn.vencenter.ourlife.entity.QuartzJob;
import cn.vencenter.ourlife.service.JobService;
import config.AppConfig;
import lib.MESSAGEXsend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OurlifeApplicationTests {
    @Autowired
    private JobService jobService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void quartz() {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobName("task1");
        quartzJob.setJobGroup("jaychou");
        quartzJob.setDescription("我的第一个任务");
        quartzJob.setJobClassName(MyJob.class.getName());
        quartzJob.setCronExpression("0/7 * * * * ?");
        quartzJob.setTriggerName("trigger1");
        quartzJob.setTriggerState("trigger");
        quartzJob.setOldJobName("");
        quartzJob.setOldJobGroup("");
        quartzJob.setJobDataParam(null);
        jobService.save(quartzJob);
    }

    @Test
    public void start() {
        jobService.triggerJob("task1","jaychou");
    }

    @Test
    public void sendMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1290274972@qq.com");
        message.setTo("1290274972@qq.com");
        message.setSubject("jaychou");
        message.setText("this is a test");
        long a = System.currentTimeMillis();
        jobService.sendMail(message);
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }

    @Test
    public void message() {

        AppConfig appConfig = new AppConfig();
        appConfig.setAppId("38648");
        appConfig.setAppKey("79238e076c7f8dcd7de67524ee51adc9");
        appConfig.setSignType("msg_signtype");
        MESSAGEXsend messageXsend = new MESSAGEXsend(appConfig);
        messageXsend.addTo("15047806594");
        messageXsend.setProject("EPiEk2");
        messageXsend.addVar("code","200");
        String xsend = messageXsend.xsend();
    }

}
