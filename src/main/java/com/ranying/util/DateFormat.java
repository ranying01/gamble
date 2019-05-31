package com.ranying.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static String dateFormateBriefYmd(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date);
    }

    public static String dateFormateYmd(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static Date paseDate(String dataStr){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date;
        try {
            date = simpleDateFormat.parse(dataStr);
        }catch (Exception e){
            date = null;
        }
        return date;
    }

    public static Date paseDateSimple(String dataStr){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(dataStr);
        }catch (Exception e){
            date = null;
        }
        return date;
    }


}
