package com.qbwl.aspect_demo.FileResolverUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.qbwl.aspect_demo.dataStageUtils.DataStageEntity;
import com.qbwl.aspect_demo.dataStageUtils.FtpEntity;
import com.qbwl.aspect_demo.dataStageUtils.enums.E_OperationType;
import org.apache.commons.lang3.StringUtils;

import java.io.*;


/**
 * @author:Hayden
 * @Date:2019/8/5
 */
public class AnalysisUtil {



    public static void analsisSqlFile() {
        File file = new File(FtpEntity.sqlPath);
        File[] files = file.listFiles();
        assert files != null;
        for (int i = 0; i < files.length; i++) {


            String name = files[i].getName();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(files[i])));

                while (br.read() != -1) {
                    String s = "{"+br.readLine();
                    System.out.println(s);
                    DataStageEntity o = JSON.parseObject(s,DataStageEntity.class);
                    //获取实体类名称
                    String entity = o.getTableType();
                    System.out.println(entity);

                    String methodName = o.getMethodName();
                    System.out.println(methodName);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        }

    private static void replaceName(String name) {
        switch (name) {
            case "INSERT":

                break;
            case "UPDATE":

                break;
            case "DELETE":

                break;
            default:
        }
    }

    public static void main (String[]args){
                AnalysisUtil.analsisSqlFile();
            }
    }