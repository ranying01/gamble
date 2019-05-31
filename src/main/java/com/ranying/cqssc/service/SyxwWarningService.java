package com.ranying.cqssc.service;

import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.vo.SyxwWarningRow;

import java.util.List;

public interface SyxwWarningService {

    List<SyxwWarningRow> listWarning(SyxwParamQuery query);
}
