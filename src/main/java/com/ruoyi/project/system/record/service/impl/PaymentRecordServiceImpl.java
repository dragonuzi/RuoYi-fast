package com.ruoyi.project.system.record.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.record.mapper.PaymentRecordMapper;
import com.ruoyi.project.system.record.domain.PaymentRecord;
import com.ruoyi.project.system.record.service.IPaymentRecordService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 缴费记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class PaymentRecordServiceImpl implements IPaymentRecordService 
{
    @Autowired
    private PaymentRecordMapper paymentRecordMapper;

    /**
     * 查询缴费记录
     * 
     * @param prId 缴费记录主键
     * @return 缴费记录
     */
    @Override
    public PaymentRecord selectPaymentRecordByPrId(Long prId)
    {
        return paymentRecordMapper.selectPaymentRecordByPrId(prId);
    }

    /**
     * 查询缴费记录列表
     * 
     * @param paymentRecord 缴费记录
     * @return 缴费记录
     */
    @Override
    public List<PaymentRecord> selectPaymentRecordList(PaymentRecord paymentRecord)
    {
        return paymentRecordMapper.selectPaymentRecordList(paymentRecord);
    }

    /**
     * 新增缴费记录
     * 
     * @param paymentRecord 缴费记录
     * @return 结果
     */
    @Override
    public int insertPaymentRecord(PaymentRecord paymentRecord)
    {
        User curUser= ShiroUtils.getSysUser();
        paymentRecord.setCreateByid(curUser.getUserId());
        paymentRecord.setCreateBy(curUser.getUserName());
        paymentRecord.setCreateTime(DateUtils.getNowDate());
        paymentRecord.setUpdateByid(curUser.getUserId());
        paymentRecord.setUpdateBy(curUser.getUserName());
        paymentRecord.setUpdateTime(DateUtils.getNowDate());
        return paymentRecordMapper.insertPaymentRecord(paymentRecord);
    }

    /**
     * 修改缴费记录
     * 
     * @param paymentRecord 缴费记录
     * @return 结果
     */
    @Override
    public int updatePaymentRecord(PaymentRecord paymentRecord)
    {
        paymentRecord.setUpdateTime(DateUtils.getNowDate());
        return paymentRecordMapper.updatePaymentRecord(paymentRecord);
    }

    /**
     * 批量删除缴费记录
     * 
     * @param prIds 需要删除的缴费记录主键
     * @return 结果
     */
    @Override
    public int deletePaymentRecordByPrIds(String prIds)
    {
        return paymentRecordMapper.deletePaymentRecordByPrIds(Convert.toStrArray(prIds));
    }

    /**
     * 删除缴费记录信息
     * 
     * @param prId 缴费记录主键
     * @return 结果
     */
    @Override
    public int deletePaymentRecordByPrId(Long prId)
    {
        return paymentRecordMapper.deletePaymentRecordByPrId(prId);
    }
}
