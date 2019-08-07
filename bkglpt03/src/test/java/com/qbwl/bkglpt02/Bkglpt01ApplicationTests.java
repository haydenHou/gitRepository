package com.qbwl.bkglpt02;

import com.qbwl.bkglpt02.dao.WarningMapper;
import com.qbwl.bkglpt02.entity.Warning;
import com.qbwl.bkglpt02.service.IQGZTService;
import com.qbwl.bkglpt02.service.InformationMatchingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Bkglpt01ApplicationTests {

    @Autowired
    IQGZTService qgztService;


    @Autowired
    WarningMapper warningMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        short a = 2;
        Warning warning = warningMapper.getByPrimaryKey(a);
        System.out.println(warning);
    }


    /**
     *
     * @param count 总数量
     * @param pageNum 第几页
     * @return
     */
   private String[] getNumByPageNum(Integer count,Integer pageNum){
    StringBuilder builder = new StringBuilder();
//        每页数量
       int pageSize = 5;
//       总页数
       int num = count / pageSize;
       int remainder = count % pageSize;
       if(remainder>0){
           num +=1;
       }

       int start = (pageNum-1)*pageSize +1;
       builder.append(start);
       builder.append(",");
       int end = pageNum*pageSize;
       builder.append(end);
       System.out.println("总页数\t"+num);
       System.out.println("总条数\t"+count);
       System.out.println("startNum:\t"+start);
       System.out.println("endNum:\t"+end);
       String[] split = builder.toString().split(",");
       return split;
   }


   @Autowired
    InformationMatchingService informationMatchingService;

    @Test
    public void contextLoads01() {
        informationMatchingService.matchingZTRY();
    }


    @Test
    public void match(){
        String str = "152,null,王启生\n" +
                ",null,null,null,null,412323196803161630\n" +
                ",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,（2018）陕0104执司惩365号\t（2017）陕0104民初7805号民事判决书\t李蔷13152193482\n" +
                ",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null";
        String[] split = str.split(",");
        System.out.println(split.length);

    }

}
