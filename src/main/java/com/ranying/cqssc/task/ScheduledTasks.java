package com.ranying.cqssc.task;

import com.ranying.cqssc.service.NotifyService;
import com.ranying.cqssc.service.SyncDataService;
import com.ranying.cqssc.service.WarningResultsService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@EnableScheduling
public class ScheduledTasks {

    @Resource
    private NotifyService notifyService;

    @Resource
    private SyncDataService syncDataService;

    @Resource
    private WarningResultsService warningResultsService;

    // @Scheduled(fixedRate = 1000 * 30)

    /**
     * 每天凌晨 0点 5分 30 秒 同步上一天的数据，解决12点以后不同步数据的bug
     */
    @Scheduled(cron = "30 6 0 * * ?")
    public void syncYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        syncDataService.sync(calendar.getTime());
    }

    /**
     * 每天早上 9 点发短信
     **/
    @Scheduled(cron = "0 0 9 * * ? ")
    public void reportCurrentTime() {
        System.out.println("Scheduling Tasks : The time is now " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        notifyService.searchAndSendMsg();
    }

    //每20分钟执行一次,同步数据
    @Scheduled(cron = "0 */5 *  * * *")
    public void sync() {
        syncDataService.sync(new Date());
    }

    //每15分钟执行一次
    @Scheduled(cron = "0 */15 * * * *")
    public void statisticsWarning() {
        warningResultsService.statisticsWarning();
    }

}
