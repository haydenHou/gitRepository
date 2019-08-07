package com.jhbh.jxyqyd.service.comService.impl;

import com.jhbh.jxyqyd.dao.IndexArticleDao;
import com.jhbh.jxyqyd.entity.IndexArticle;
import com.jhbh.jxyqyd.service.comService.IIndexArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/4/22
 */
@Service
public class IndexArticleImpl implements IIndexArticleService {

    @Autowired
    IndexArticleDao indexArticleMapper;

    @Override
    public List<IndexArticle> getIndexAbstract() {
        List<IndexArticle> indexAbstract = indexArticleMapper.getIndexAbstract();
        for (IndexArticle s:indexAbstract) {
            switch (s.getArticleType()){
                case "1":
                    s.setArticleType("法律法规");
                    break;
                case "2":
                    s.setArticleType("新闻信息");
                    break;
                    default:
            }
        }
        return indexAbstract;
    }
}
