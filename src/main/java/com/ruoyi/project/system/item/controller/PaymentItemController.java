package com.ruoyi.project.system.item.controller;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.record.domain.PaymentRecord;
import com.ruoyi.project.system.record.service.IPaymentRecordService;
import com.ruoyi.project.system.student.domain.Student;
import com.ruoyi.project.system.student.service.IStudentService;
import com.ruoyi.project.system.user.domain.User;
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
    @Autowired
    private IPaymentRecordService paymentRecordService;
    @Autowired
    private IStudentService studentService;

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
     * 打开支付页
     */
    @RequiresPermissions("system:item:pay")
    @GetMapping("/pay/{piId}")
    public String pay(@PathVariable("piId") Long piId, ModelMap mmap)
    {
        PaymentItem paymentItem = paymentItemService.selectPaymentItemByPiId(piId);
        mmap.put("paymentItem", paymentItem);
        //判断是否已有缴费记录，如有，弹窗提示
        //1.查询学生学生id，若无学生id，返回无需缴费
        //2.根据缴费项id和学生id，查询缴费记录，若有，返回错误信息，无需缴费；若无，可以继续缴费
        User curUser=ShiroUtils.getSysUser();
        Student param=new Student();
        param.setStuUserid(curUser.getUserId());
        List<Student> students=studentService.selectStudentList(param);
        if(students==null||students.size()==0){
            mmap.addAttribute("msg","您没有待缴费的项目！");
            return "/error/warning";
        }else {
            Student student=students.get(0);
            PaymentRecord param1=new PaymentRecord();
            param1.setPrPiid(paymentItem.getPiId());
            param1.setPrStuid(student.getStuId());
            List<PaymentRecord> records=paymentRecordService.selectPaymentRecordList(param1);
            if(records!=null&&records.size()!=0){
                mmap.addAttribute("msg","您已缴费，请勿重复缴费！");
                return "/error/warning";
            }
        }
        return prefix + "/pay";
    }

    /**
     * 修改保存缴费项目
     */
    @RequiresPermissions("system:item:pay")
    @Log(title = "缴费", businessType = BusinessType.INSERT)
    @PostMapping("/pay")
    @ResponseBody
    public AjaxResult paySave(PaymentItem paymentItem)
    {
        //生成一条缴费记录
        User curUser= ShiroUtils.getSysUser();
        Student param=new Student();
        param.setStuUserid(curUser.getUserId());
        List<Student> students=studentService.selectStudentList(param);
        Student student=students.get(0);
        PaymentRecord paymentRecord=new PaymentRecord();
        paymentRecord.setPrPiid(paymentItem.getPiId());
        paymentRecord.setPrPiname(paymentItem.getPiName());
        paymentRecord.setPrPiamount(paymentItem.getPiAmount());
        paymentRecord.setPrStuid(student.getStuId());
        paymentRecord.setPrStuno(student.getStuNo());
        paymentRecord.setPrStuname(student.getStuName());
        paymentRecord.setPrPaytime(DateUtils.getNowDate());
        return toAjax(paymentRecordService.insertPaymentRecord(paymentRecord));
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
