package com.ranying;


import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.util.EmailTool;
import com.ranying.util.SimpleMailParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class EmailToolTest {

    @Resource
    private EmailTool emailTool;

    @Resource
    private SyxwSyncDataService syxwSyncDataService;

    //@Test
    public void test(){

        /*SimpleMailParam simpleMail = new SimpleMailParam("1756251697@qq.com","彩票接口警告测试邮件", "彩票结果异常，请知悉");
        MimeMessage mimeMessage = emailTool.sendSimpleMail(simpleMail);
        System.out.println(mimeMessage);*/

        syxwSyncDataService.sync(SyxwConstant.LotteryType.GD, new Date());

    }


}
