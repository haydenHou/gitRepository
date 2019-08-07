package com.jhbh.jxyqyd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author:Hayden
 * @String:2019/4/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexArticle extends BaseEntity{
//  自增主键
  private Integer  articleId;
//  标题
  private String   articleTitle;
//  类型
  private String   articleType;
//  作者
  private String   articleAuthor;
//  内容
  private String   articleContent;
//  状态 0.不显示到主页 ;1.显示到主页
  private String   status;
//  生成时间
  private String  createTime;
//  更改时间
  private String   modifiedTime;

  private String  photo;



  public IndexArticle() {
  }

  public IndexArticle(String articleTitle, String articleType, String articleAuthor, String articleContent, String status, String createTime, String modifiedTime) {
    this.articleTitle = articleTitle;
    this.articleType = articleType;
    this.articleAuthor = articleAuthor;
    this.articleContent = articleContent;
    this.status = status;
    this.createTime = createTime;
    this.modifiedTime = modifiedTime;
  }
}
