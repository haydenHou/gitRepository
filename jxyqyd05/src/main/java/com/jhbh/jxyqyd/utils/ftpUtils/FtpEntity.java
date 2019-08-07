package com.jhbh.jxyqyd.utils.ftpUtils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Author:Hayden
 * @Date:2019/2/22
 * ftp参数配置
 */

@Data
@Component
public class FtpEntity {

    public static String ftpUsername = "localftp";

    public static String ftpPassword = "www.ftp";

    public static String ftpBathPath = "/jxy_data/image/";

    public static Integer ftpPort = 21;

    public static String ftpAddress = "111.21.51.70";

    public static String logPath = "G:/appData/jxyqyd/logs/";

    public static String nativePath = "G:/appData/jxyqyd/image/";

    public static String sqlPath = "G:/appData/jxyqyd/sql/";

    static {
        Properties pro = new Properties();
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(FtpEntity.class.getResourceAsStream("/ftp.yml"), "utf-8");
            pro.load(in);
            ftpUsername = pro.getProperty("username");
            ftpPassword = pro.getProperty("password");
            ftpBathPath = pro.getProperty("basePath");
            ftpPort = Integer.valueOf(pro.getProperty("port"));
            ftpAddress = pro.getProperty("address");
            logPath = pro.getProperty("logPath");
            nativePath = pro.getProperty("nativePath");
            sqlPath = pro.getProperty("sqlPath");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}