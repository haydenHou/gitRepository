package com.qbwl.bkglpt02.service;

import com.qbwl.bkglpt02.entity.Keyarea;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author:Hayden
 * @Date:2019/7/17
 */
public interface IKeyareaService {
    /**
     * 根据kaid删除对应报警信息
     * @param kaid 序列id
     */
    void deleteByPrimaryKey(BigDecimal kaid);

    /**
     * 添加报警信息
     * @param record  kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     */
    void insert(Keyarea record);

    /**
     * 选择性插入报警信息（可为空）
     * @param record  kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     */
    void insertSelective(Keyarea record);

    /**
     * 根据kaid查询详细报警信息
     * @param kaid 序列id
     */
    Keyarea getByPrimaryKey(BigDecimal kaid);

    /**
     * 根据可以类型和治安管理机构查询
     * @param record katype,kasecurityorg
     * @return kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     */
    List<Keyarea> listByKatypeAndKasecurityorg(Keyarea record);

    /**
     * 根据kaid选择性更改报警信息
     * @param record kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     * @return 成功返回1，失败为0
     */
    void updateByPrimaryKeySelective(Keyarea record);

    /**
     * 根据kaid全量更改报警信息
     * @param record kaword, kamark, katype, kauser, kaalert, kanum, kasecurityorg, kainfotype, kadate
     * @return 成功返回1，失败为0
     */
    void updateByPrimaryKey(Keyarea record);
}
