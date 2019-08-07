package com.jhbh.jxyqyd.utils;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * @Author:Hayden
 * @Date:2019/3/7
 * 用于生成MD5加密的工具类
 */
public class Md5Util {
    /**
     * 对字符串加密
     * @param str 密码
     * @return 加密后的字符
     */
    public static String md5(String str){
        int count = 5;
        String md5 = null;
        for(int i=0;i<count;i++){
            md5 = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        }
        return md5;
    }

    /**
     * 对密码进行加密，对随机数进行加密
     * 拼接后再进行加密
     */
    public static String MD5PR(String pwd,String salt){
        return md5(md5(pwd)+md5(salt));
    }

    /**
     *获取随机数作为盐
     * @return 随机盐
     */
    public static String  getRandomSalt(){
        int r = new Random().nextInt(1000);
        return Integer.toString(r);
    }


}
