package cn.vencenter.ourlife.service.JobserviceImpl;

import cn.vencenter.ourlife.entity.QuartzJob;
import cn.vencenter.ourlife.job.MyJob;
import cn.vencenter.ourlife.service.JobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-20 14:22
 * @version:
 **/
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void save(QuartzJob quartzJob) {

        try {
            if (quartzJob.getOldJobGroup() != null && !"".equals(quartzJob.getOldJobGroup())) {
                JobKey jobKey = new JobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
                scheduler.deleteJob(jobKey);
            }
            Class<MyJob> aClass = (Class<MyJob>)Class.forName(quartzJob.getJobClassName());
            JobDetail jobDetail = JobBuilder.newJob(aClass).withIdentity(quartzJob.getJobName(), quartzJob.getJobGroup()).withDescription(quartzJob.getDescription()).build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzJob.getJobName() + quartzJob.getJobName(), quartzJob.getJobGroup()).withSchedule(cronScheduleBuilder).startNow().build();
            scheduler.scheduleJob(jobDetail,trigger);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void triggerJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pauseJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resumeJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
