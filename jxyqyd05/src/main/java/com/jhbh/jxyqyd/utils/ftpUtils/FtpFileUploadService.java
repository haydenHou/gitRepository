package com.jhbh.jxyqyd.utils.ftpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * @Author:Hayden
 * @Date:2019/2/20
 */
@Service
public class FtpFileUploadService{
    private static Logger logger = LoggerFactory.getLogger(FtpFileUploadService.class);

    /**
     * 创建用于存放上传图片缓存的队列
     */
    private Queue<String> queue = new LinkedList<>();

    /**
     * 默认文件本地缓存路径
     */
    private final static  String PATH = FtpEntity.nativePath;

    /**
     * 生成上传文件名
     * @param file 上传文件
     * @return 156083051911310.jpg
     */
    private String getFileName(MultipartFile file) {
        long l = System.currentTimeMillis();
        Random r = new Random();
        int i = r.nextInt(100);
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String substring = fileName.substring(fileName.lastIndexOf("."));
        return l+""+i+substring;
    }



    /**
     * 将文件缓存在本地指定文件夹中
     * 并将存入本地的图片名称加入到queue队列中
     * @return fileName 文件名称
     * @throws IOException
     */
    public StringBuilder savePic(HttpServletRequest request) throws IOException {
        Long srartTime = System.currentTimeMillis();
        InputStream is;
        OutputStream os = null;
        String fileName = null;
        StringBuilder fileNames = new StringBuilder();
        // 如果有从多个文件，则获取多个
        List<MultipartFile> file = ((MultipartHttpServletRequest) request).getFiles("file");
        int size = file.size();
        for (int i = 0; i < size ; i++) {
            MultipartFile files = file.get(i);
            fileName = getFileName(files);
            queue.offer(fileName);
            is = files.getInputStream();
            try {
                // 2、保存到临时文件
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流保存到本地文件
                File tempFile = new File(PATH);
                if (!tempFile.exists()) {
                    tempFile.mkdirs();
                }
                os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                fileNames.append(fileName);
                if(size - i > 1){
                    fileNames.append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 完毕，关闭所有链接
                try {
                    assert os != null;
                    os.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        logger.info("{} 存储本地成功,用时: {} ms",fileName,endTime-srartTime);

        return fileNames;
    }


    /**
     * 每30分钟执行该方法，
     * 如果队列中存在未上传的文件
     * 将队列中的该文件进行上传，并移除队列
     * 上传成功之后
     * 将该文件在本地删除
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void autoUploadFile(){
        File file = new File(PATH);
        FileInputStream fs = null;
        if(queue.size()>0) {
            if (file.exists()) {
                while (queue.size()!=0){
                    String fileName = queue.poll();
                    upFile(fs,fileName);
                }
            }
        }else {
            File[] files = file.listFiles();
            assert files != null;
            if(files.length != 0){
                for (File f:files) {
                    String fileName = f.getName();
                    upFile(fs,fileName);
                }
            }
        }
    }

    /**
     * 提取出的用于上传文件的方法
     * @param fs 文件读取流
     * @param fileName 文件名
     */
    private void upFile(FileInputStream fs,String fileName){
        File file1 = new File(PATH + fileName);
        if (file1.exists()) {
            try {
                fs = new FileInputStream(file1);
                Long srartTime = System.currentTimeMillis();
                logger.info("{} 文件上传中",fileName);
                if (FtpFileUtils.uploadFile(fileName, fs)) {
                    Long endTime = System.currentTimeMillis();
                    logger.info("{} 文件上传成功，用时：{} ms",fileName,endTime-srartTime);
                    file1.delete();
                }else{
                    throw new FileNotFoundException("文件 -"+fileName+"- 上传失败");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fs != null;
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
