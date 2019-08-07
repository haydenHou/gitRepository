package com.jhbh.jxyqyd.service.GBService.GBImpl;

import com.jhbh.jxyqyd.dao.gb.GbDegreeDao;
import com.jhbh.jxyqyd.entity.GB.GbDegreeTable;
import com.jhbh.jxyqyd.service.GBService.IGbDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
@Service
public class GbDegreeImpl implements IGbDegreeService {

    @Autowired
    GbDegreeDao gbDegreeMapper;


    @Override
    public List<GbDegreeTable> getDegreeCode() {
        return gbDegreeMapper.getDegree();
    }
}
