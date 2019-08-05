package com.qbwl.aspect_demo.FileResolverUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qbwl.aspect_demo.dataStageUtils.DataStageEntity;
import com.qbwl.aspect_demo.dataStageUtils.FtpEntity;

import java.io.*;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @author:Hayden
 * @Date:2019/8/5
 */
public class AnalysisUtil {



    public static void analsisSqlFile(){
        File file = new File(FtpEntity.sqlPath);
        File[] files = file.listFiles();
        assert files != null;
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(files[i])));
                String s = br.readLine();
                DataStageEntity o = JSON.parseObject(s, DataStageEntity.class);
                String tableName = o.getTableName();
                System.out.println(tableName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (name){
                case "INSERT":

                    break;
                case "UPDATE":

                    break;
                case "DELETE":

                    break;
                    default:
            }
        }
    }

    public static void main(String[] args) {
        AnalysisUtil.analsisSqlFile();
    }
}
