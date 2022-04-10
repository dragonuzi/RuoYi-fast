package com.ruoyi.project.system.leaveword.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.leaveword.mapper.LeavewordMapper;
import com.ruoyi.project.system.leaveword.domain.Leaveword;
import com.ruoyi.project.system.leaveword.service.ILeavewordService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 留言Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class LeavewordServiceImpl implements ILeavewordService 
{
    @Autowired
    private LeavewordMapper leavewordMapper;

    /**
     * 查询留言
     * 
     * @param lwId 留言主键
     * @return 留言
     */
    @Override
    public Leaveword selectLeavewordByLwId(Long lwId)
    {
        return leavewordMapper.selectLeavewordByLwId(lwId);
    }

    /**
     * 查询留言列表
     * 
     * @param leaveword 留言
     * @return 留言
     */
    @Override
    public List<Leaveword> selectLeavewordList(Leaveword leaveword)
    {
        return leavewordMapper.selectLeavewordList(leaveword);
    }

    /**
     * 新增留言
     * 
     * @param leaveword 留言
     * @return 结果
     */
    @Override
    public int insertLeaveword(Leaveword leaveword)
    {
        User curUser= ShiroUtils.getSysUser();
        leaveword.setCreateByid(curUser.getUserId());
        leaveword.setCreateBy(curUser.getUserName());
        leaveword.setCreateTime(DateUtils.getNowDate());
        leaveword.setUpdateByid(curUser.getUserId());
        leaveword.setUpdateBy(curUser.getUserName());
        leaveword.setUpdateTime(DateUtils.getNowDate());
        leaveword.setLwLeavetime(DateUtils.getNowDate());
        leaveword.setLwUserid(curUser.getUserId());
        leaveword.setLwUsername(curUser.getUserName());
        return leavewordMapper.insertLeaveword(leaveword);
    }

    /**
     * 修改留言
     * 
     * @param leaveword 留言
     * @return 结果
     */
    @Override
    public int updateLeaveword(Leaveword leaveword)
    {
        User curUser= ShiroUtils.getSysUser();
        leaveword.setUpdateByid(curUser.getUserId());
        leaveword.setUpdateBy(curUser.getUserName());
        leaveword.setUpdateTime(DateUtils.getNowDate());
        return leavewordMapper.updateLeaveword(leaveword);
    }

    /**
     * 批量删除留言
     * 
     * @param lwIds 需要删除的留言主键
     * @return 结果
     */
    @Override
    public int deleteLeavewordByLwIds(String lwIds)
    {
        return leavewordMapper.deleteLeavewordByLwIds(Convert.toStrArray(lwIds));
    }

    /**
     * 删除留言信息
     * 
     * @param lwId 留言主键
     * @return 结果
     */
    @Override
    public int deleteLeavewordByLwId(Long lwId)
    {
        return leavewordMapper.deleteLeavewordByLwId(lwId);
    }
}
