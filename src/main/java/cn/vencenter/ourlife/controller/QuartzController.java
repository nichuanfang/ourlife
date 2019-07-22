package cn.vencenter.ourlife.controller;

import cn.vencenter.ourlife.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-20 15:41
 * @version:
 **/
@Controller
public class QuartzController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/start")
    public void start() {
        jobService.triggerJob("task1","jaychou");
    }




}
