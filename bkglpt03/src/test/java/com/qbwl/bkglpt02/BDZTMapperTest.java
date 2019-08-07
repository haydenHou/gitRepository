package com.qbwl.bkglpt02;

import com.qbwl.bkglpt02.dao.BDZTRYMapper;
import com.qbwl.bkglpt02.entity.BDZTRY;
import com.qbwl.bkglpt02.entity.PageEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
public class BDZTMapperTest extends Bkglpt01ApplicationTests {

    @Autowired
    BDZTRYMapper bdztryMapper;

    @Test
    public void getBDZTByBH(){
        BDZTRY bdztry = new BDZTRY();
//        bdztry.setRXm("刘");
//        bdztry.setStartNum(1);
//        bdztry.setEndNum(5);
//        List<BDZTRY> bdztries = bdztryMapper.listShowEnteringBdzt(bdztry);
//        System.out.println(bdztries);


//        BDZTRY byPrimaryKey = bdztryMapper.getByPrimaryKey("077");
//        System.out.println(byPrimaryKey);

//        bdztry.setRXm("赵四");
//        int insert = bdztryMapper.insert(bdztry);
//        System.out.println(insert);


        PageEntity<BDZTRY> pageEntity = new PageEntity<>();
        pageEntity.setPageSize(5);
        System.out.println(pageEntity);

    }
}
