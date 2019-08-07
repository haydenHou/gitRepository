package com.jhbh.jxyqyd.service.GBService;


import com.jhbh.jxyqyd.entity.GB.GbDegreeTable;

import java.util.List;

/**
 * @Author:Hayden
 * @Date:2019/3/29
 */
public interface IGbDegreeService {


    /**
     * 根据学历名称获取学历代码
     * @return gb_degree_id，type_code，degree，explain
     */
    List<GbDegreeTable> getDegreeCode();
}
