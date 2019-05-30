package com.ranying.cqssc.controller;

import com.ranying.cqssc.service.SyncDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("cqssc")
public class CqsscSyncDataController {

    @Autowired
    private SyncDataService syncDataService;

    @RequestMapping("sync")
    public void sync() {
        syncDataService.sync();
    }

    @RequestMapping("sync_all")
    public void syncAll() throws ParseException, InterruptedException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-04-01");
        calendar.setTime(date);
        while (calendar.getTimeInMillis() < new Date().getTime()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            System.out.println(simpleDateFormat.format(calendar.getTime()));
            Thread.sleep(1000);
            syncDataService.sync(calendar.getTime());
        }
    }

    @RequestMapping("sync_date")
    public void syncDate(String dateStr) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateStr);
        syncDataService.sync(date);
    }
}
