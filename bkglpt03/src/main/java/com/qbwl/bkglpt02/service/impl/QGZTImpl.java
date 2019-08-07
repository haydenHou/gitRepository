package com.qbwl.bkglpt02.service.impl;

import com.qbwl.bkglpt02.dao.QGZTRYMapper;
import com.qbwl.bkglpt02.entity.BDZTRY;
import com.qbwl.bkglpt02.entity.QGZTRY;
import com.qbwl.bkglpt02.service.IQGZTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/4
 */
@Service
public class QGZTImpl implements IQGZTService {

    @Autowired
    QGZTRYMapper qgztryMapper;

    @Override
    public QGZTRY getByPrimaryKey(String rRybh) {
        return qgztryMapper.getByPrimaryKey(rRybh);
    }

    @Override
    public List<QGZTRY> listBySFZH(QGZTRY qgztry) {
        return qgztryMapper.listBySFZH(qgztry);
    }


    @Override
    public List<QGZTRY> listShowEnteringBdzt(BDZTRY bdztry) {
        return qgztryMapper.listShowEnteringBdzt(bdztry);
    }
}
