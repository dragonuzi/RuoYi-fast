package com.ruoyi.project.system.class1.service;

import java.util.List;
import com.ruoyi.project.system.class1.domain.Class1;

/**
 * 班级Service接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface IClass1Service 
{
    /**
     * 查询班级
     * 
     * @param classId 班级主键
     * @return 班级
     */
    public Class1 selectClass1ByClassId(Long classId);

    /**
     * 查询班级列表
     * 
     * @param class1 班级
     * @return 班级集合
     */
    public List<Class1> selectClass1List(Class1 class1);

    /**
     * 新增班级
     * 
     * @param class1 班级
     * @return 结果
     */
    public int insertClass1(Class1 class1);

    /**
     * 修改班级
     * 
     * @param class1 班级
     * @return 结果
     */
    public int updateClass1(Class1 class1);

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的班级主键集合
     * @return 结果
     */
    public int deleteClass1ByClassIds(String classIds);

    /**
     * 删除班级信息
     * 
     * @param classId 班级主键
     * @return 结果
     */
    public int deleteClass1ByClassId(Long classId);
}
