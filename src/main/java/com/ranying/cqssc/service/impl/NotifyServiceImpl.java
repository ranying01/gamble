package com.ranying.cqssc.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.ranying.cqssc.service.NotifyService;
import com.ranying.cqssc.dao.LotteryParamDAO;
import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.service.SyncDataService;
import com.ranying.cqssc.vo.GenerateRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NotifyServiceImpl implements NotifyService {

    private static Logger logger = LoggerFactory.getLogger(NotifyServiceImpl.class);

    @Resource
    private LotteryParamDAO lotteryParamDAO;

    @Resource
    private SyncDataService syncDataService;

    @Override
    public void searchAndSendMsg() {

        // 查询 数据库的所有 匹配概率
        List<LotteryParam> paramList = lotteryParamDAO.findAll();
        for (LotteryParam param : paramList) {
            List<GenerateRow> rows =  syncDataService.generate(param);
            for (GenerateRow row : rows) {
               /* if (row.getPeriod() != null && row.getPeriod() > param.getMaxLeaveOut() * 0.4) {
                    logger.info("LatestExpect:" + row.getLatestExpect() + "Location:" + row.getLocation() + row.getTimes() + row.getTimes());
                }*/
            }
        }
        sendMsg("520");
    }

    public void sendMsg(String code){

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIj0FdPKnhFyhJ", "MfmXLoX51bOek6N1IoI56OIhVizuBi");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13681144479");
        request.putQueryParameter("SignName", "ranying");
        request.putQueryParameter("TemplateCode", "SMS_164151111");
        request.putQueryParameter("TemplateParam", "{\"code\":\"532\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
