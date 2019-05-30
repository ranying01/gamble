package com.ranying.syxw.controller;

import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.syxw.vo.SyxwMaxNeglectResult;
import com.ranying.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("syxw")
public class SyxwSyncDataController {

    @Autowired
    private SyxwSyncDataService syncDataService;

    @RequestMapping("sync")
    public void sync() {
        syncDataService.sync(SyxwConstant.LotteryType.GD, new Date());
    }

    @RequestMapping("sync_all")
    public void syncAll(String type) throws ParseException, InterruptedException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-01-01");
        calendar.setTime(date);
        SyxwConstant.LotteryType syxwType = SyxwConstant.SYXW_TYPE_MAP.get(type);
        if (syxwType == null) {
            throw new RuntimeException("彩票类型不能为空");
        }
        while (calendar.getTimeInMillis() < new Date().getTime()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Thread.sleep(5000);
            syncDataService.sync(syxwType, calendar.getTime());
        }
    }

    @RequestMapping("sync_date")
    public void syncDate(String dateStr) throws ParseException {
        if (StringUtils.isBlank(dateStr)) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateStr);
        syncDataService.sync(SyxwConstant.LotteryType.GD, date);
    }

    @RequestMapping("search_max_neglect")
    public Result<SyxwMaxNeglectResult> searchMaxNeglect(@RequestParam("type") String type, @RequestParam("numbers") String numbers) {
        Result<SyxwMaxNeglectResult> result = new Result<>();
        try {
            SyxwMaxNeglectResult maxNeglect = syncDataService.searchMaxNeglect(type, numbers);
            result.setData(maxNeglect);
            result.setCode(200);
        }catch (Exception e){
            result.setCode(500);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
