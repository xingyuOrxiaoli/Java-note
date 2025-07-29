package com.xiaoli.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

    // 任务方法
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 生命要让quartz自动调用处理的功能代码
        System.out.println("MyJob   ");

    }
}
