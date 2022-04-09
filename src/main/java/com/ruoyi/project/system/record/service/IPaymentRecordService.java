package com.ruoyi.project.system.record.service;

import java.util.List;
import com.ruoyi.project.system.record.domain.PaymentRecord;

/**
 * 缴费记录Service接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface IPaymentRecordService 
{
    /**
     * 查询缴费记录
     * 
     * @param prId 缴费记录主键
     * @return 缴费记录
     */
    public PaymentRecord selectPaymentRecordByPrId(Long prId);

    /**
     * 查询缴费记录列表
     * 
     * @param paymentRecord 缴费记录
     * @return 缴费记录集合
     */
    public List<PaymentRecord> selectPaymentRecordList(PaymentRecord paymentRecord);

    /**
     * 新增缴费记录
     * 
     * @param paymentRecord 缴费记录
     * @return 结果
     */
    public int insertPaymentRecord(PaymentRecord paymentRecord);

    /**
     * 修改缴费记录
     * 
     * @param paymentRecord 缴费记录
     * @return 结果
     */
    public int updatePaymentRecord(PaymentRecord paymentRecord);

    /**
     * 批量删除缴费记录
     * 
     * @param prIds 需要删除的缴费记录主键集合
     * @return 结果
     */
    public int deletePaymentRecordByPrIds(String prIds);

    /**
     * 删除缴费记录信息
     * 
     * @param prId 缴费记录主键
     * @return 结果
     */
    public int deletePaymentRecordByPrId(Long prId);
}
