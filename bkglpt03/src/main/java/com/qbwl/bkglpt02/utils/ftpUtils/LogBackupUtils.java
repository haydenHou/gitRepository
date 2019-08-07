package com.qbwl.bkglpt02.utils.ftpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author:Hayden
 * @Date:2019/4/18
 */
@Component
public class LogBackupUtils {
    private static Logger logger = LoggerFactory.getLogger(LogBackupUtils.class);


    /**
     * 每天凌晨两点进行日拷贝
     * @throws IOException io异常
     * 每天11:55进行日志备份
     */
    @Scheduled(cron ="0 55 23 * * ?")
    public void  CopyLogBack() throws IOException {

//        从文件列表中抽取当天的文件
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String filePath1 = FtpEntity.logPath;
//        String filePath1 = f.getLogPath();
        File file = new File(filePath1);

        List<String> files = new ArrayList<>();
        List<String> FilesPath = getFilePath(file, files);
//        定义文件名
            for (String filePath : FilesPath) {
//        拆分出文件名称
                String substring = filePath.substring(filePath.lastIndexOf("\\")+1);
                if(filePath.contains(date)) {
                    FileInputStream  fis = new FileInputStream(filePath);
                    if(FtpFileUtils.uploadFile(substring, fis)){
                        logger.info("【上传成功,上传时间：{}，文件名称：{}】",date,substring);
                    }
                    fis.close();
                }
            }

    }

    /**
     * 获取文件路径
     * @param file 文件
     * @param files 文件路径集合
     * @return 文件路径集合
     */
    private List<String> getFilePath(File file, List<String> files) throws FileNotFoundException {
            File[] files1 = file.listFiles();
            if( files1 != null) {
                for (File aFiles1 : files1) {
                    if (aFiles1.isFile()) {
                        files.add(aFiles1.getAbsolutePath());
                    }else {
                        getFilePath(aFiles1, files);
                    }
                }
            }else{
                throw new FileNotFoundException("此路径下没有文件生成");
            }
            return files;
        }
}


