package org.lancereally.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//（把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>）
@Component
public class SchedualDemo {
    @Scheduled(cron = "*/60 * * * * *")
    public static void Time(){
        int i = 0;
        System.out.println("定时任务实现：1 在启动类添加@EnableScheduling 2 在任务类添加@Component");
    }

//    示例 cron = [秒] [分] [小时] [日] [月] [周] [年](可省略)
//    每隔5秒执行一次：*/5 * * * * ?
//    每隔1分钟执行一次：0 */1 * * * ?
//    每天23点执行一次：0 0 23 * * ?
//    每天凌晨1点执行一次：0 0 1 * * ?
//    每月1号凌晨1点执行一次：0 0 1 1 * ?
//    每月最后一天23点执行一次：0 0 23 L * ?
//    每周星期天凌晨1点实行一次：0 0 1 ? * L
//    在26分、29分、33分执行一次：0 26,29,33 * * * ?
//    每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

}
