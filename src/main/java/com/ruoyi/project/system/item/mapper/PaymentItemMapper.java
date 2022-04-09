package com.ruoyi.project.system.item.mapper;

import java.util.List;
import com.ruoyi.project.system.item.domain.PaymentItem;

/**
 * 缴费项目Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public interface PaymentItemMapper 
{
    /**
     * 查询缴费项目
     * 
     * @param piId 缴费项目主键
     * @return 缴费项目
     */
    public PaymentItem selectPaymentItemByPiId(Long piId);

    /**
     * 查询缴费项目列表
     * 
     * @param paymentItem 缴费项目
     * @return 缴费项目集合
     */
    public List<PaymentItem> selectPaymentItemList(PaymentItem paymentItem);

    /**
     * 新增缴费项目
     * 
     * @param paymentItem 缴费项目
     * @return 结果
     */
    public int insertPaymentItem(PaymentItem paymentItem);

    /**
     * 修改缴费项目
     * 
     * @param paymentItem 缴费项目
     * @return 结果
     */
    public int updatePaymentItem(PaymentItem paymentItem);

    /**
     * 删除缴费项目
     * 
     * @param piId 缴费项目主键
     * @return 结果
     */
    public int deletePaymentItemByPiId(Long piId);

    /**
     * 批量删除缴费项目
     * 
     * @param piIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePaymentItemByPiIds(String[] piIds);
}
