package com.ranying.cqssc.service;

import com.github.pagehelper.PageInfo;
import com.ranying.cqssc.entity.WarningResult;
import com.ranying.cqssc.query.WarningResultQuery;


public interface WarningResultsService {

    PageInfo<WarningResult> listResult(WarningResultQuery query);

    void statisticsWarning();

}
