package lhh.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: IdeaJava
 * @Date: 2019/12/1 19:35
 * @Author: lhh
 * @Description:
 */
public class TimeStampTest {
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);

        String mm = null;
        int mms = 0;
        mm = String.format("%tm",new Date(Long.parseLong(String.valueOf(timeStamp))));
        mms  = new Date(Long.parseLong(String.valueOf(timeStamp))).getMonth();
        System.out.println("mm: " + mm);
        System.out.println("mms: " + mms);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println("格式化结果：" + sd2);
    }

}
