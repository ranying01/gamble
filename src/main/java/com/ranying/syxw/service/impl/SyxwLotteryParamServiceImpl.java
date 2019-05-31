package com.ranying.syxw.service.impl;

import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.dao.SyxwLotteryParamDAO;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.service.SyxwLotteryParamService;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.syxw.vo.SyxwGenerateResultVO;
import com.ranying.syxw.vo.SyxwGenerateRow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class SyxwLotteryParamServiceImpl implements SyxwLotteryParamService {

    @Resource
    private SyxwLotteryParamDAO syxwLotteryParamDAO;

    @Resource
    private SyxwSyncDataService syxwSyncDataService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(SyxwLotteryParam lotteryParam) {
        Map<String,SyxwConstant.LotteryType> map = SyxwConstant.SYXW_TYPE_MAP;
        for(Map.Entry<String, SyxwConstant.LotteryType> entry : map.entrySet()){
            lotteryParam.setType(entry.getKey());
            this.save(lotteryParam);
        }
    }

    @Override
    public void save(SyxwLotteryParam lotteryParam) {
        if (lotteryParam == null) {
            return;
        }
        lotteryParam.setName(lotteryParam.getName().trim());
        lotteryParam.setNumbers(lotteryParam.getNumbers().trim());
        SyxwParamQuery query = new SyxwParamQuery();
        lotteryParam.setAmount(lotteryParam.getNumbers().split(",").length);
        query.setType(lotteryParam.getType());
        query.setName(lotteryParam.getName());
        List<SyxwLotteryParam> list = syxwLotteryParamDAO.listByQuery(query);
        if (!list.isEmpty()) {
            throw new RuntimeException("存在名称" + lotteryParam.getName());
        }
        query = new SyxwParamQuery();
        query.setNumbers(lotteryParam.getName());
        list = syxwLotteryParamDAO.listByQuery(query);
        if (!list.isEmpty()) {
            throw new RuntimeException("存在数据:" + lotteryParam.getNumbers());
        }
        syxwLotteryParamDAO.insert(lotteryParam);
    }

    @Override
    public void delete(Integer id) {
        syxwLotteryParamDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<SyxwLotteryParam> list(SyxwParamQuery syxwParamQuery) {
        return syxwLotteryParamDAO.listByQuery(syxwParamQuery);
    }

    @Override
    public SyxwGenerateResultVO analyze(Integer id) {
        SyxwGenerateResultVO syxwGenerateResultVO = new SyxwGenerateResultVO();
        SyxwLotteryParam syxwLotteryParam = syxwLotteryParamDAO.selectByPrimaryKey(id);
        List<SyxwGenerateRow> rows = syxwSyncDataService.generate(syxwLotteryParam);
        syxwGenerateResultVO.setGenerateRows(rows);
        syxwGenerateResultVO.setLotteryParam(syxwLotteryParam);
        return syxwGenerateResultVO;
    }

    @Override
    public SyxwLotteryParam getEntity(Integer id) {
        return syxwLotteryParamDAO.selectByPrimaryKey(id);
    }

    @Override
    public void update(SyxwLotteryParam syxwLotteryParam) {
        Integer maxNeglect = syxwLotteryParam.getMaxNeglect();
        SyxwLotteryParam updateParam = new SyxwLotteryParam();
        updateParam.setId(syxwLotteryParam.getId());
        updateParam.setMaxNeglect(maxNeglect);
        syxwLotteryParamDAO.updateByPrimaryKeySelective(updateParam);
    }


}
