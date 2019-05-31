package com.ranying.cqssc.dao;

import com.ranying.cqssc.entity.WarningResult;
import com.ranying.cqssc.query.WarningResultQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarningResultDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(WarningResult record);

    int insertSelective(WarningResult record);

    WarningResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarningResult record);

    int updateByPrimaryKey(WarningResult record);

    List<WarningResult> list(WarningResultQuery query);

}