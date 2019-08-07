package com.qbwl.bkglpt02.aspect.service;

import com.qbwl.bkglpt02.aspect.bo.SysLogBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhuzhe
 * @date 2018/6/4 9:41
 * @email 1529949535@qq.com
 */
@Slf4j
@Service
public class SysLogService {

    public boolean save(SysLogBO sysLogBO){
        log.info(sysLogBO.getParams());
        return true;
    }
}
