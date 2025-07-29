import com.xiaoli.QuartzApplication;
import com.xiaoli.quartz.MyJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = QuartzApplication.class)
public class TestQZ {


    @Autowired
    private Scheduler scheduler;

    @Test
    public void TestAddMyJob() throws SchedulerException {
        // 创建任务的JobDetail：描述吧任务执行的细节以及其他要求，如任务的名称，分组
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("name1", "group1")
                .build();
        // 创建触发器  描述任务除法的时机
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .withIdentity("t1", "g1")
                .build();
        // 将任务和触发器绑定在一起，并让任务调度器开始监听
        scheduler.scheduleJob(jobDetail,cronTrigger);
        // 开始调度
        scheduler.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void TestRemoveMyJob() throws SchedulerException {
        // 删任务 不是删除触发器，因为这个触发器可能其他任务也在用
        scheduler.deleteJob(new JobKey("name1","group1"));

    }
    @Test
    public void TestUpdateMyJob() throws SchedulerException {
        // 获取当前任务的触发器
        TriggerKey triggerKey = TriggerKey.triggerKey("t1", "g1");
        // 获取触发器
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 修改触发器
        trigger = trigger.getTriggerBuilder()
                .withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();
        // 资源调度器重新加载触发器
        scheduler.rescheduleJob(triggerKey,trigger);
    }

    @Test
    public void TesPauseMyJob() throws SchedulerException {
        // 获取暂停的任务
        JobKey jobKey = new JobKey("name1", "group1");
        // 让任务资源调度器，暂停任务调度
        scheduler.pauseJob(jobKey);
    }

    @Test
    public void TestResumeMyJob() throws SchedulerException {

        // 获取重启的任务
        JobKey jobKey = new JobKey("name1", "group1");
        // 让任务资源调度器，暂停任务调度
        scheduler.resumeJob(jobKey);
    }
    @Test
    public void TestSelectMyJob() throws SchedulerException {
        // 获取任务调度的组信息
        GroupMatcher<JobKey> jobKeyGroupMatcher = GroupMatcher.anyJobGroup();
        // 获取任务调度的job信息
        Set<JobKey> jobKeys = scheduler.getJobKeys(jobKeyGroupMatcher);

        for (JobKey jobKey : jobKeys) {
            // 获取任务调度的触发器信息
            List<? extends Trigger> triggersOfJob = scheduler.getTriggersOfJob(jobKey);
            System.out.println("====================================================");
            for (Trigger trigger : triggersOfJob) {
                System.out.println(jobKey.getName());
                System.out.println(jobKey.getGroup());
                System.out.println(scheduler.getTriggerState(trigger.getKey()));
                System.out.println(((CronTrigger) trigger).getCronExpression());
            }
        }
    }
}
