package com.ruoyi.project.system.dormitory.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.dormitory.mapper.DormitoryMapper;
import com.ruoyi.project.system.dormitory.domain.Dormitory;
import com.ruoyi.project.system.dormitory.service.IDormitoryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 宿舍信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class DormitoryServiceImpl implements IDormitoryService 
{
    @Autowired
    private DormitoryMapper dormitoryMapper;

    /**
     * 查询宿舍信息
     * 
     * @param dorId 宿舍信息主键
     * @return 宿舍信息
     */
    @Override
    public Dormitory selectDormitoryByDorId(Long dorId)
    {
        return dormitoryMapper.selectDormitoryByDorId(dorId);
    }

    /**
     * 查询宿舍信息列表
     * 
     * @param dormitory 宿舍信息
     * @return 宿舍信息
     */
    @Override
    public List<Dormitory> selectDormitoryList(Dormitory dormitory)
    {
        return dormitoryMapper.selectDormitoryList(dormitory);
    }

    /**
     * 新增宿舍信息
     * 
     * @param dormitory 宿舍信息
     * @return 结果
     */
    @Override
    public int insertDormitory(Dormitory dormitory)
    {
        dormitory.setCreateTime(DateUtils.getNowDate());
        return dormitoryMapper.insertDormitory(dormitory);
    }

    /**
     * 修改宿舍信息
     * 
     * @param dormitory 宿舍信息
     * @return 结果
     */
    @Override
    public int updateDormitory(Dormitory dormitory)
    {
        dormitory.setUpdateTime(DateUtils.getNowDate());
        return dormitoryMapper.updateDormitory(dormitory);
    }

    /**
     * 批量删除宿舍信息
     * 
     * @param dorIds 需要删除的宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteDormitoryByDorIds(String dorIds)
    {
        return dormitoryMapper.deleteDormitoryByDorIds(Convert.toStrArray(dorIds));
    }

    /**
     * 删除宿舍信息信息
     * 
     * @param dorId 宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteDormitoryByDorId(Long dorId)
    {
        return dormitoryMapper.deleteDormitoryByDorId(dorId);
    }

    /**
     * 查询宿舍信息树列表
     * 
     * @return 所有宿舍信息信息
     */
    @Override
    public List<Ztree> selectDormitoryTree()
    {
        List<Dormitory> dormitoryList = dormitoryMapper.selectDormitoryList(new Dormitory());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Dormitory dormitory : dormitoryList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(dormitory.getDorId());
            ztree.setpId(dormitory.getDorParentid());
            ztree.setName(dormitory.getDorNo());
            ztree.setTitle(dormitory.getDorNo());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
