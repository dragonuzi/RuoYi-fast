package com.ruoyi.project.system.checkin.mapper;

import java.util.List;
import com.ruoyi.project.system.checkin.domain.Checkin;

/**
 * 新生报到记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface CheckinMapper 
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
     * 删除新生报到记录
     * 
     * @param checkinId 新生报到记录主键
     * @return 结果
     */
    public int deleteCheckinByCheckinId(Long checkinId);

    /**
     * 批量删除新生报到记录
     * 
     * @param checkinIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCheckinByCheckinIds(String[] checkinIds);
}
