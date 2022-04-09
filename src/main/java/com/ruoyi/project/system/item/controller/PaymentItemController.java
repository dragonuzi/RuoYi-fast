package com.ruoyi.project.system.item.controller;

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
import com.ruoyi.project.system.item.domain.PaymentItem;
import com.ruoyi.project.system.item.service.IPaymentItemService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 缴费项目Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/item")
public class PaymentItemController extends BaseController
{
    private String prefix = "system/item";

    @Autowired
    private IPaymentItemService paymentItemService;

    @RequiresPermissions("system:item:view")
    @GetMapping()
    public String item()
    {
        return prefix + "/item";
    }

    /**
     * 查询缴费项目列表
     */
    @RequiresPermissions("system:item:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PaymentItem paymentItem)
    {
        startPage();
        List<PaymentItem> list = paymentItemService.selectPaymentItemList(paymentItem);
        return getDataTable(list);
    }

    /**
     * 导出缴费项目列表
     */
    @RequiresPermissions("system:item:export")
    @Log(title = "缴费项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PaymentItem paymentItem)
    {
        List<PaymentItem> list = paymentItemService.selectPaymentItemList(paymentItem);
        ExcelUtil<PaymentItem> util = new ExcelUtil<PaymentItem>(PaymentItem.class);
        return util.exportExcel(list, "缴费项目数据");
    }

    /**
     * 新增缴费项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存缴费项目
     */
    @RequiresPermissions("system:item:add")
    @Log(title = "缴费项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PaymentItem paymentItem)
    {
        return toAjax(paymentItemService.insertPaymentItem(paymentItem));
    }

    /**
     * 修改缴费项目
     */
    @RequiresPermissions("system:item:edit")
    @GetMapping("/edit/{piId}")
    public String edit(@PathVariable("piId") Long piId, ModelMap mmap)
    {
        PaymentItem paymentItem = paymentItemService.selectPaymentItemByPiId(piId);
        mmap.put("paymentItem", paymentItem);
        return prefix + "/edit";
    }

    /**
     * 修改保存缴费项目
     */
    @RequiresPermissions("system:item:edit")
    @Log(title = "缴费项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PaymentItem paymentItem)
    {
        return toAjax(paymentItemService.updatePaymentItem(paymentItem));
    }

    /**
     * 删除缴费项目
     */
    @RequiresPermissions("system:item:remove")
    @Log(title = "缴费项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(paymentItemService.deletePaymentItemByPiIds(ids));
    }
}
