package com.ranying;

import com.ranying.cqssc.service.SyncDataService;
import com.ranying.cqssc.service.WarningResultsService;
import com.ranying.util.DateFormat;
import com.ranying.cqssc.vo.GenerateParamVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SyncTest {

    @Autowired
    private SyncDataService syncDataService;

    @Autowired
    private WarningResultsService warningResultsService;

    public void test() {
        Long currentTime = System.currentTimeMillis();
        String startDateStr = "2019-04-01";
        Date startDate = DateFormat.paseDateSimple(startDateStr);
        System.out.println(currentTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        while (calendar.getTimeInMillis() < currentTime) {
            calendar.add(Calendar.DATE, 1);
            System.out.println(DateFormat.dateFormateYmd(calendar.getTime()));
            syncDataService.sync(calendar.getTime());
        }
    }

    public void test2(){

        GenerateParamVO generateParamVO = new GenerateParamVO();
        generateParamVO.setNumbers("008 016 024 032 040 058 066 074 082 090 107 115 123 131 149 157 165 173 181 199 206 214 222 230 248 256 264 272 280 298 305 313 321 339 347 355 363 371 389 397 404 412 420 438 446 454 462 470 488 496 503 511 529 537 545 553 561 579 587 595 602 610 628 636 644 652 660 678 686 694 701 719 727 735 743 751 769 777 785 793 800 818 826 834 842 850 868 876 884 892 909 917 925 933 941 959 967 975 983 991");
        //syncDataService.generate(generateParamVO);
    }

    @Test
    public void warningResults(){
        warningResultsService.statisticsWarning();
    }

}
