package cn.vencenter.ourlife.service;

import cn.vencenter.ourlife.entity.QuartzJob;
import org.quartz.Job;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-20 14:14
 * @version:
 **/
public interface JobService {

    void save(QuartzJob quartzJob);

    void triggerJob(String jobName,String jobGroup);

    void pauseJob(String jobName,String jobGroup);

    void resumeJob(String jobName,String jobGroup);

    void removeJob(String jobName,String jobGroup);
}
