package com.ranying.syxw.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * SyxwConstant.LotteryType
 */
public class SyxwConstant {

    public static Map<String, LotteryType> SYXW_TYPE_MAP;

    static {
        SYXW_TYPE_MAP = new HashMap<>();
        SYXW_TYPE_MAP.put(LotteryType.GD.getValue(), LotteryType.GD);
        SYXW_TYPE_MAP.put(LotteryType.JX.getValue(), LotteryType.JX);
        SYXW_TYPE_MAP.put(LotteryType.SH.getValue(), LotteryType.SH);
        SYXW_TYPE_MAP.put(LotteryType.SD.getValue(), LotteryType.SD);
        SYXW_TYPE_MAP.put(LotteryType.JS.getValue(), LotteryType.JS);
    }

    public enum LotteryType {
        GD("gd11x5", "广东11选5"),
        JX("jx11x5", "江西11选5"),
        SH("sh11x5", "上海11选5"),
        SD("sd11x5", "山东11选5"),
        JS("js11x5", "江苏11选5");

        private String value;

        private String name;

        LotteryType(String value, String name) {
            this.value = value;
            this.name = name;
        }


        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
