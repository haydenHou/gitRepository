package com.jhbh.jxyqyd;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @author:Hayden
 * @Date:2019/5/16
 */
public class UtilsTest extends JxyqydApplicationTests {

    /**
     * 获取三天前日期
     * 若获取三天后  取正值
     */
    @Test
    public void DayTest(){
        Calendar calendar1 = Calendar.getInstance();
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
//        calendar1.add(Calendar.DATE, -3);
//        String three_days_ago = sdf1.format(calendar1.getTime());
//        System.out.println(three_days_ago);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(calendar1.get(Calendar.MONTH)+1);
        String three_days_ago = sdf1.format(calendar1.getTime());
        System.out.println(three_days_ago);

        System.out.println(calendar1.get(Calendar.DATE));
    }

    @Test
    public void test01(){
//        System.out.println(System.currentTimeMillis());

        char [] c = {65,74};
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int l = r.nextInt(10);
            System.out.println(c[l]);
        }
    }






}
