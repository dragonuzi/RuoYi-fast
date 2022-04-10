package com.ruoyi.project.system.major.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.major.mapper.MajorMapper;
import com.ruoyi.project.system.major.domain.Major;
import com.ruoyi.project.system.major.service.IMajorService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 专业信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class MajorServiceImpl implements IMajorService 
{
    @Autowired
    private MajorMapper majorMapper;

    /**
     * 查询专业信息
     * 
     * @param majorId 专业信息主键
     * @return 专业信息
     */
    @Override
    public Major selectMajorByMajorId(Long majorId)
    {
        return majorMapper.selectMajorByMajorId(majorId);
    }

    /**
     * 查询专业信息列表
     * 
     * @param major 专业信息
     * @return 专业信息
     */
    @Override
    public List<Major> selectMajorList(Major major)
    {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 新增专业信息
     * 
     * @param major 专业信息
     * @return 结果
     */
    @Override
    public int insertMajor(Major major)
    {
        User curUser= ShiroUtils.getSysUser();
        major.setCreateByid(curUser.getUserId());
        major.setCreateBy(curUser.getUserName());
        major.setCreateTime(DateUtils.getNowDate());
        major.setUpdateByid(curUser.getUserId());
        major.setUpdateBy(curUser.getUserName());
        major.setUpdateTime(DateUtils.getNowDate());
        return majorMapper.insertMajor(major);
    }

    /**
     * 修改专业信息
     * 
     * @param major 专业信息
     * @return 结果
     */
    @Override
    public int updateMajor(Major major)
    {
        User curUser= ShiroUtils.getSysUser();
        major.setUpdateByid(curUser.getUserId());
        major.setUpdateBy(curUser.getUserName());
        major.setUpdateTime(DateUtils.getNowDate());
        return majorMapper.updateMajor(major);
    }

    /**
     * 批量删除专业信息
     * 
     * @param majorIds 需要删除的专业信息主键
     * @return 结果
     */
    @Override
    public int deleteMajorByMajorIds(String majorIds)
    {
        return majorMapper.deleteMajorByMajorIds(Convert.toStrArray(majorIds));
    }

    /**
     * 删除专业信息信息
     * 
     * @param majorId 专业信息主键
     * @return 结果
     */
    @Override
    public int deleteMajorByMajorId(Long majorId)
    {
        return majorMapper.deleteMajorByMajorId(majorId);
    }
}
