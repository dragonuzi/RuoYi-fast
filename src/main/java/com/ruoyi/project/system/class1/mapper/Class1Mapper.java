package com.ruoyi.project.system.class1.mapper;

import java.util.List;
import com.ruoyi.project.system.class1.domain.Class1;
import org.springframework.stereotype.Repository;

/**
 * 班级Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Repository
public interface Class1Mapper 
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
     * 删除班级
     * 
     * @param classId 班级主键
     * @return 结果
     */
    public int deleteClass1ByClassId(Long classId);

    /**
     * 批量删除班级
     * 
     * @param classIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClass1ByClassIds(String[] classIds);
}
