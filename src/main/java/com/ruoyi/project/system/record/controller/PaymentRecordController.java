package com.ruoyi.project.system.record.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.record.domain.PaymentRecord;
import com.ruoyi.project.system.record.service.IPaymentRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 缴费记录Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/record")
public class PaymentRecordController extends BaseController
{
    private String prefix = "system/record";

    @Autowired
    private IPaymentRecordService paymentRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询缴费记录列表
     */
    @RequiresPermissions("system:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PaymentRecord paymentRecord)
    {
        startPage();
        List<PaymentRecord> list = paymentRecordService.selectPaymentRecordList(paymentRecord);
        return getDataTable(list);
    }

    /**
     * 导出缴费记录列表
     */
    @RequiresPermissions("system:record:export")
    @Log(title = "缴费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PaymentRecord paymentRecord)
    {
        List<PaymentRecord> list = paymentRecordService.selectPaymentRecordList(paymentRecord);
        ExcelUtil<PaymentRecord> util = new ExcelUtil<PaymentRecord>(PaymentRecord.class);
        return util.exportExcel(list, "缴费记录数据");
    }

    /**
     * 新增缴费记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存缴费记录
     */
    @RequiresPermissions("system:record:add")
    @Log(title = "缴费记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PaymentRecord paymentRecord)
    {
        return toAjax(paymentRecordService.insertPaymentRecord(paymentRecord));
    }

    /**
     * 修改缴费记录
     */
    @RequiresPermissions("system:record:edit")
    @GetMapping("/edit/{prId}")
    public String edit(@PathVariable("prId") Long prId, ModelMap mmap)
    {
        PaymentRecord paymentRecord = paymentRecordService.selectPaymentRecordByPrId(prId);
        mmap.put("paymentRecord", paymentRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存缴费记录
     */
    @RequiresPermissions("system:record:edit")
    @Log(title = "缴费记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PaymentRecord paymentRecord)
    {
        return toAjax(paymentRecordService.updatePaymentRecord(paymentRecord));
    }

    /**
     * 删除缴费记录
     */
    @RequiresPermissions("system:record:remove")
    @Log(title = "缴费记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(paymentRecordService.deletePaymentRecordByPrIds(ids));
    }
}
