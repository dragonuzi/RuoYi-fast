package com.ruoyi.project.system.checkin.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.checkin.mapper.CheckinMapper;
import com.ruoyi.project.system.checkin.domain.Checkin;
import com.ruoyi.project.system.checkin.service.ICheckinService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 新生报到记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class CheckinServiceImpl implements ICheckinService 
{
    @Autowired
    private CheckinMapper checkinMapper;

    /**
     * 查询新生报到记录
     * 
     * @param checkinId 新生报到记录主键
     * @return 新生报到记录
     */
    @Override
    public Checkin selectCheckinByCheckinId(Long checkinId)
    {
        return checkinMapper.selectCheckinByCheckinId(checkinId);
    }

    /**
     * 查询新生报到记录列表
     * 
     * @param checkin 新生报到记录
     * @return 新生报到记录
     */
    @Override
    public List<Checkin> selectCheckinList(Checkin checkin)
    {
        return checkinMapper.selectCheckinList(checkin);
    }

    /**
     * 新增新生报到记录
     * 
     * @param checkin 新生报到记录
     * @return 结果
     */
    @Override
    public int insertCheckin(Checkin checkin)
    {
        checkin.setCreateTime(DateUtils.getNowDate());
        return checkinMapper.insertCheckin(checkin);
    }

    /**
     * 修改新生报到记录
     * 
     * @param checkin 新生报到记录
     * @return 结果
     */
    @Override
    public int updateCheckin(Checkin checkin)
    {
        checkin.setUpdateTime(DateUtils.getNowDate());
        return checkinMapper.updateCheckin(checkin);
    }

    /**
     * 批量删除新生报到记录
     * 
     * @param checkinIds 需要删除的新生报到记录主键
     * @return 结果
     */
    @Override
    public int deleteCheckinByCheckinIds(String checkinIds)
    {
        return checkinMapper.deleteCheckinByCheckinIds(Convert.toStrArray(checkinIds));
    }

    /**
     * 删除新生报到记录信息
     * 
     * @param checkinId 新生报到记录主键
     * @return 结果
     */
    @Override
    public int deleteCheckinByCheckinId(Long checkinId)
    {
        return checkinMapper.deleteCheckinByCheckinId(checkinId);
    }
}
