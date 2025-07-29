package com.xiaoli.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduled {

    // 每隔两秒
    @Scheduled(cron = "0/2 * * * * *")
    public void testScheduled(){
        System.out.println("每隔两秒 执行一次");
    }



}
