package com.jhbh.jxyqyd.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author:Hayden
 * @Date:2019/5/31
 * 正则和参数配置等自定义属性
 */
@Data
@Component
@Configuration
@PropertySource("classpath:utils.properties")
public class PatternEntity {

    /**
     * 邮箱正则
     */
    @Value("${pattern.email}")
    private   String email;

    /**
     * 电话正则
     */
    @Value("${pattern.phone}")
    private  String phone;

    /**
     * 身份证号正则
     */
    @Value("${pattern.idcode}")
    private  String idcode;
}
