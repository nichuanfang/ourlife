package cn.vencenter.ourlife.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-20 14:27
 * @version:
 **/
@Data
public class QuartzJob {
    private String jobName;//任务名称
    private String jobGroup;//任务分组
    private String description;//任务描述
    private String jobClassName;//执行类
    private String cronExpression;//cron表达式
    private String triggerName;//触发器名称
    private String triggerState;//触发器状态

    private String oldJobName;//任务名称 用于修改
    private String oldJobGroup;//任务分组 用于修改

    private List<Map<String, Object>> jobDataParam;

    public QuartzJob() {
        super();
    }
    public QuartzJob(String jobName, String jobGroup, String description, String jobClassName, String cronExpression, String triggerName) {
        super();
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.description = description;
        this.jobClassName = jobClassName;
        this.cronExpression = cronExpression;
        this.triggerName = triggerName;
    }
}
