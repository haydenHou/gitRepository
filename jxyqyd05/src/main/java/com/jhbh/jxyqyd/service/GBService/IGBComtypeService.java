package com.jhbh.jxyqyd.service.GBService;

import com.jhbh.jxyqyd.entity.GB.GbComtypeTable;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
public interface IGBComtypeService {

    List<GbComtypeTable> listComtyoe();

    GbComtypeTable  getNameByCode(String code);

}
