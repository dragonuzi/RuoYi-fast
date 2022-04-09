package com.ruoyi.project.system.leaveword.mapper;

import java.util.List;
import com.ruoyi.project.system.leaveword.domain.Leaveword;

/**
 * 留言Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface LeavewordMapper 
{
    /**
     * 查询留言
     * 
     * @param lwId 留言主键
     * @return 留言
     */
    public Leaveword selectLeavewordByLwId(Long lwId);

    /**
     * 查询留言列表
     * 
     * @param leaveword 留言
     * @return 留言集合
     */
    public List<Leaveword> selectLeavewordList(Leaveword leaveword);

    /**
     * 新增留言
     * 
     * @param leaveword 留言
     * @return 结果
     */
    public int insertLeaveword(Leaveword leaveword);

    /**
     * 修改留言
     * 
     * @param leaveword 留言
     * @return 结果
     */
    public int updateLeaveword(Leaveword leaveword);

    /**
     * 删除留言
     * 
     * @param lwId 留言主键
     * @return 结果
     */
    public int deleteLeavewordByLwId(Long lwId);

    /**
     * 批量删除留言
     * 
     * @param lwIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLeavewordByLwIds(String[] lwIds);
}
