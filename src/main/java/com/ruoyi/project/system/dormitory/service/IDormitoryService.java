package com.ruoyi.project.system.dormitory.service;

import java.util.List;
import com.ruoyi.project.system.dormitory.domain.Dormitory;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 宿舍信息Service接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface IDormitoryService 
{
    /**
     * 查询宿舍信息
     * 
     * @param dorId 宿舍信息主键
     * @return 宿舍信息
     */
    public Dormitory selectDormitoryByDorId(Long dorId);

    /**
     * 查询宿舍信息列表
     * 
     * @param dormitory 宿舍信息
     * @return 宿舍信息集合
     */
    public List<Dormitory> selectDormitoryList(Dormitory dormitory);

    /**
     * 新增宿舍信息
     * 
     * @param dormitory 宿舍信息
     * @return 结果
     */
    public int insertDormitory(Dormitory dormitory);

    /**
     * 修改宿舍信息
     * 
     * @param dormitory 宿舍信息
     * @return 结果
     */
    public int updateDormitory(Dormitory dormitory);

    /**
     * 批量删除宿舍信息
     * 
     * @param dorIds 需要删除的宿舍信息主键集合
     * @return 结果
     */
    public int deleteDormitoryByDorIds(String dorIds);

    /**
     * 删除宿舍信息信息
     * 
     * @param dorId 宿舍信息主键
     * @return 结果
     */
    public int deleteDormitoryByDorId(Long dorId);

    /**
     * 查询宿舍信息树列表
     * 
     * @return 所有宿舍信息信息
     */
    public List<Ztree> selectDormitoryTree();
}
