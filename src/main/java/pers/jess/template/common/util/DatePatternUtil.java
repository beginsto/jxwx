package pers.jess.template.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePatternUtil {

    /**
     * 日期转字符串
     * @param d
     * @return yyyyMMdd
     */
    public static String DateToString(Date d){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        return sf.format(d);
    }
}
