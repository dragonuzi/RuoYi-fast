package com.ruoyi.project.system.checkin.service;

import java.util.List;
import com.ruoyi.project.system.checkin.domain.Checkin;

/**
 * 新生报到记录Service接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface ICheckinService 
{
    /**
     * 查询新生报到记录
     * 
     * @param checkinId 新生报到记录主键
     * @return 新生报到记录
     */
    public Checkin selectCheckinByCheckinId(Long checkinId);

    /**
     * 查询新生报到记录列表
     * 
     * @param checkin 新生报到记录
     * @return 新生报到记录集合
     */
    public List<Checkin> selectCheckinList(Checkin checkin);

    /**
     * 新增新生报到记录
     * 
     * @param checkin 新生报到记录
     * @return 结果
     */
    public int insertCheckin(Checkin checkin);

    /**
     * 修改新生报到记录
     * 
     * @param checkin 新生报到记录
     * @return 结果
     */
    public int updateCheckin(Checkin checkin);

    /**
     * 批量删除新生报到记录
     * 
     * @param checkinIds 需要删除的新生报到记录主键集合
     * @return 结果
     */
    public int deleteCheckinByCheckinIds(String checkinIds);

    /**
     * 删除新生报到记录信息
     * 
     * @param checkinId 新生报到记录主键
     * @return 结果
     */
    public int deleteCheckinByCheckinId(Long checkinId);
}
