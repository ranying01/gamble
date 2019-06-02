package com.ranying.syxw.task;

import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.service.SyxwSyncDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

@Component
@EnableScheduling
public class SyxwScheduledTasks {

    @Value("${task.flag}")
    private Boolean taskFlag;

    @Resource
    private SyxwSyncDataService syncDataService;

    /**
     * 每天凌晨 0点 5分 46 秒 同步上一天的数据，解决12点以后不同步数据的bug
     */
    @Scheduled(cron = "46 5 0 * * ?")
    public void syncYesterday() {
        if (!taskFlag) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        this.processSync(calendar.getTime());

    }

    private void processSync(Date date) {
        if (!taskFlag) {
            return;
        }
        try {
            syncDataService.sync(SyxwConstant.LotteryType.GD, date);
            Thread.sleep(10000);
            syncDataService.sync(SyxwConstant.LotteryType.JS, date);
            Thread.sleep(10000);
            syncDataService.sync(SyxwConstant.LotteryType.SH, date);
            Thread.sleep(10000);
            syncDataService.sync(SyxwConstant.LotteryType.JX, date);
            Thread.sleep(10000);
            syncDataService.sync(SyxwConstant.LotteryType.SD, date);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //每10分钟执行一次,同步数据
    @Scheduled(cron = "0 */3 *  * * *")
    public void sync() {
        if (!taskFlag) {
            return;
        }
        Date date = new Date();
        this.processSync(date);
    }

}
