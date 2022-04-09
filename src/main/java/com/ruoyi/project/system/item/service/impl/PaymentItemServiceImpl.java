package com.ruoyi.project.system.item.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.item.mapper.PaymentItemMapper;
import com.ruoyi.project.system.item.domain.PaymentItem;
import com.ruoyi.project.system.item.service.IPaymentItemService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 缴费项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class PaymentItemServiceImpl implements IPaymentItemService 
{
    @Autowired
    private PaymentItemMapper paymentItemMapper;

    /**
     * 查询缴费项目
     * 
     * @param piId 缴费项目主键
     * @return 缴费项目
     */
    @Override
    public PaymentItem selectPaymentItemByPiId(Long piId)
    {
        return paymentItemMapper.selectPaymentItemByPiId(piId);
    }

    /**
     * 查询缴费项目列表
     * 
     * @param paymentItem 缴费项目
     * @return 缴费项目
     */
    @Override
    public List<PaymentItem> selectPaymentItemList(PaymentItem paymentItem)
    {
        return paymentItemMapper.selectPaymentItemList(paymentItem);
    }

    /**
     * 新增缴费项目
     * 
     * @param paymentItem 缴费项目
     * @return 结果
     */
    @Override
    public int insertPaymentItem(PaymentItem paymentItem)
    {
        paymentItem.setCreateTime(DateUtils.getNowDate());
        return paymentItemMapper.insertPaymentItem(paymentItem);
    }

    /**
     * 修改缴费项目
     * 
     * @param paymentItem 缴费项目
     * @return 结果
     */
    @Override
    public int updatePaymentItem(PaymentItem paymentItem)
    {
        paymentItem.setUpdateTime(DateUtils.getNowDate());
        return paymentItemMapper.updatePaymentItem(paymentItem);
    }

    /**
     * 批量删除缴费项目
     * 
     * @param piIds 需要删除的缴费项目主键
     * @return 结果
     */
    @Override
    public int deletePaymentItemByPiIds(String piIds)
    {
        return paymentItemMapper.deletePaymentItemByPiIds(Convert.toStrArray(piIds));
    }

    /**
     * 删除缴费项目信息
     * 
     * @param piId 缴费项目主键
     * @return 结果
     */
    @Override
    public int deletePaymentItemByPiId(Long piId)
    {
        return paymentItemMapper.deletePaymentItemByPiId(piId);
    }
}
