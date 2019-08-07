package com.qbwl.bkglpt02.utils.ftpUtils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:Hayden
 * @Date:2019/2/20
 */
public class FtpFileUtils {

  public static Logger log = LoggerFactory.getLogger(FtpFileUtils.class);

    /**
     * 链接地址
     */
    private final static String FTP_ADDRESS = FtpEntity.ftpAddress;
    /**
     * 端口号
     */
    private final static Integer FTP_PORT = FtpEntity.ftpPort;
    /**
     * 用户名
     */
    private final static String FTP_USERNAME = FtpEntity.ftpUsername;
    /**
     * 密码
     */
    private final static String FTP_PASSWORD = FtpEntity.ftpPassword;
    /**
     * 文件上传地址
     */
    private final static String BASE_PATH = FtpEntity.ftpBathPath;

    /**
     * 上传文件至ftp
     * @param originFileName 文件名
     * @param input 字节流
     * @return 成功true，失败false
     */
    public static boolean uploadFile(String originFileName, InputStream input){

        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        ftp.enterLocalPassiveMode();
        try {
            int reply;
            // 连接FTP服务器
            if(!ftp.isConnected()){
                ftp.connect(FTP_ADDRESS,FTP_PORT);
            }

            // 登录
            ftp.login(FTP_USERNAME, FTP_PASSWORD);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(BASE_PATH);
            ftp.changeWorkingDirectory(BASE_PATH);
            ftp.storeFile(originFileName,input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.getMessage();
                }
            }
        }
        return success;
    }


}
