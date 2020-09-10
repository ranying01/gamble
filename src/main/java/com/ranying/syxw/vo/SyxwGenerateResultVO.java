package com.ranying.syxw.vo;

import com.ranying.syxw.entity.SyxwLotteryParam;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分析结果
 */
@Data
public class SyxwGenerateResultVO implements Serializable {

    private SyxwGenerateRow generateRow;

    /**
     * 兼容以前的
     */
    private List<SyxwGenerateRow> generateRows;

    private SyxwLotteryParam lotteryParam;

    private int[] rang1 = new int[]{0, 0, 0};

    private int[] rang2 = new int[]{0, 0, 0};

    private int[] rang3 = new int[]{0, 0, 0};

}
