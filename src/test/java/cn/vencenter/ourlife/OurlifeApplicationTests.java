package cn.vencenter.ourlife;
import cn.vencenter.ourlife.job.MyJob;
import com.google.common.collect.Lists;

import cn.vencenter.ourlife.entity.QuartzJob;
import cn.vencenter.ourlife.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

}
