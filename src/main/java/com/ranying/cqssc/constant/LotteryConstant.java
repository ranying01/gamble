package com.ranying.cqssc.constant;

import java.util.HashMap;
import java.util.Map;

public class LotteryConstant {

    public final static Integer FAIL_CODE = 500;

    public enum Location {

        W("w", "万"),
        Q("q", "千"),
        B("b", "百"),
        S("s", "十"),
        G("g", "个");

        private String value;

        private String name;

        Location(String value, String name) {
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

    public enum Arrange {

        /**
         * 位置一
         */
        WQB("wqb", "万千百"),

        /**
         * 位置二
         */
        WQS("wqs", "万千十"),

        /**
         * 位置三
         */
        WQG("wqg", "万千个"),

        /**
         * 位置四
         */
        WBS("wbs", "万百十"),

        /**
         * 位置五
         */
        WBG("wbg", "万百个"),

        /**
         * 位置六
         */
        WSG("wsg", "万十个"),

        /**
         * 位置七
         */
        QBS("qbs", "千百十"),

        /**
         * 位置八
         */
        QBG("qbg", "千百个"),

        /**
         * 位置九
         */
        QSG("qsg", "千十个"),

        /**
         * 位置十
         */
        BSG("bsg", "百十个");

        private String value;

        private String name;

        Arrange(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static Map<String, Integer> sortMap = new HashMap<>();

       static {
           //万千百
           sortMap.put(Arrange.WQB.getName(),1);
           //万千十
           sortMap.put(Arrange.WQS.getName(),2);
           //万千个
           sortMap.put(Arrange.WQG.getName(),3);
           //万百十
           sortMap.put(Arrange.WBS.getName(),4);
           //万百个
           sortMap.put(Arrange.WBG.getName(),5);
           //万十个
           sortMap.put(Arrange.WSG.getName(),6);
           //千百十
           sortMap.put(Arrange.QBS.getName(),7);
           //千百个
           sortMap.put(Arrange.QBG.getName(),8);
           //千十个
           sortMap.put(Arrange.QSG.getName(),9);
           //百十个
           sortMap.put(Arrange.BSG.getName(),10);
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
