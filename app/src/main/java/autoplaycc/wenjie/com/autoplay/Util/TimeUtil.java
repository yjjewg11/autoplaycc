package autoplaycc.wenjie.com.autoplay.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tangt on 2016/3/4.
 */
public abstract class TimeUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static long getNowTime(){
        Date date = new Date();
        return date.getTime();
    }
}
