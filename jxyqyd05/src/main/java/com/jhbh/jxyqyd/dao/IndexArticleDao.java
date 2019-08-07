package com.jhbh.jxyqyd.dao;

import com.jhbh.jxyqyd.entity.IndexArticle;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/4/22
 */
@Repository
public interface IndexArticleDao {

    /**
     * 查询需要在登录页面展示的文章的标题，作者，时间
     * @return title，author，createTime
     */
    @Select("SELECT article_id articleId,article_title articleTitle,article_type articleType,article_content articleContent,create_time createTime  FROM article_index where  status = 1  ")
    List<IndexArticle> getIndexAbstract();


}
