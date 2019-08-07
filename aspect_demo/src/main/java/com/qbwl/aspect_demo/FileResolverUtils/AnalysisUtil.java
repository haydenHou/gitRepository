package com.qbwl.aspect_demo.FileResolverUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.qbwl.aspect_demo.dataStageUtils.DataStageEntity;
import com.qbwl.aspect_demo.dataStageUtils.FtpEntity;
import com.qbwl.aspect_demo.entity.LogInfo;
import com.qbwl.aspect_demo.entity.User;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * @author:Hayden
 * @Date:2019/8/5
 */
public class AnalysisUtil {

    public static void analsisSqlFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        File file = new File(FtpEntity.sqlPath+format);
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));

                while (br.read() != -1) {
                    String s = br.readLine();

                    if (!s.startsWith("{")) {
                        s = "{" + s;
                    }
                    DataStageEntity stageEntity = JSON.parseObject(s, DataStageEntity.class);
                    String tableType = stageEntity.getTableType();
                    Class<?> aClass = Class.forName(tableType);
                    if(User.class.getName().equals(aClass.getName())){
                        invokeUser(s);
                    }else if(LogInfo.class.getName().equals(aClass.getName())){
                        invokeCar(s);
                    }
                }
            } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert br != null;
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对文件进行解析之后执行User类型的数据库操作
     * @param s sql数据json
     */
    private static void invokeUser(String s) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        DataStageEntity<User> o = JSON.parseObject(s,new TypeReference<DataStageEntity<User>>(){});
        User args = o.getArgs();
        //获取方法名称
        Map<String, String> map = o.getMethodType();
        String[] methodParam = AnalysisUtil.getMethodParam(map);
        String methodName = methodParam[0];
        String methodClass = methodParam[1];
        Class<?> aClass = Class.forName(methodClass);
        assert methodName != null;
        Method method = aClass.getMethod(methodName,User.class);
        method.invoke(aClass.newInstance(),args);
    }

    /**
     * 对文件进行解析之后执行Car类型的数据库操作
     * @param s sql数据json
     */
    private static void invokeCar(String s) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        DataStageEntity<LogInfo> o = JSON.parseObject(s,new TypeReference<DataStageEntity<LogInfo>>(){});
        LogInfo args = o.getArgs();
        //获取方法名称
        Map<String, String> map = o.getMethodType();
        String[] methodParam = AnalysisUtil.getMethodParam(map);
        String methodName = methodParam[0];
        String methodClass = methodParam[1];
        Class<?> aClass = Class.forName(methodClass);
        assert methodName != null;
        Method method = aClass.getMethod(methodName,LogInfo.class);
        method.invoke(aClass.newInstance(),args);
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

    /**
     * @param map  封装method类型和方法名称
     * @return 0 methodName 1 methodClass
     */
    private static String[] getMethodParam(Map<String,String> map){
        String methodName = null;
        String methodClass = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "methodName":
                    methodName = entry.getValue();
                    break;
                case "methodClass":
                    methodClass = entry.getValue();
                    break;
                default:
            }
        }
        return new String[]{methodName,methodClass};
    }

    public static void main (String[]args){
                AnalysisUtil.analsisSqlFile();
            }
    }