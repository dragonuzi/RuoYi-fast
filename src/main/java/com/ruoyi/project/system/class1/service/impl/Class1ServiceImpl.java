package com.ruoyi.project.system.class1.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.class1.mapper.Class1Mapper;
import com.ruoyi.project.system.class1.domain.Class1;
import com.ruoyi.project.system.class1.service.IClass1Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 班级Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class Class1ServiceImpl implements IClass1Service 
{
    @Autowired
    private Class1Mapper class1Mapper;

    /**
     * 查询班级
     * 
     * @param classId 班级主键
     * @return 班级
     */
    @Override
    public Class1 selectClass1ByClassId(Long classId)
    {
        return class1Mapper.selectClass1ByClassId(classId);
    }

    /**
     * 查询班级列表
     * 
     * @param class1 班级
     * @return 班级
     */
    @Override
    public List<Class1> selectClass1List(Class1 class1)
    {
        return class1Mapper.selectClass1List(class1);
    }

    /**
     * 新增班级
     * 
     * @param class1 班级
     * @return 结果
     */
    @Override
    public int insertClass1(Class1 class1)
    {
        class1.setCreateTime(DateUtils.getNowDate());
        return class1Mapper.insertClass1(class1);
    }

    /**
     * 修改班级
     * 
     * @param class1 班级
     * @return 结果
     */
    @Override
    public int updateClass1(Class1 class1)
    {
        class1.setUpdateTime(DateUtils.getNowDate());
        return class1Mapper.updateClass1(class1);
    }

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的班级主键
     * @return 结果
     */
    @Override
    public int deleteClass1ByClassIds(String classIds)
    {
        return class1Mapper.deleteClass1ByClassIds(Convert.toStrArray(classIds));
    }

    /**
     * 删除班级信息
     * 
     * @param classId 班级主键
     * @return 结果
     */
    @Override
    public int deleteClass1ByClassId(Long classId)
    {
        return class1Mapper.deleteClass1ByClassId(classId);
    }
}
