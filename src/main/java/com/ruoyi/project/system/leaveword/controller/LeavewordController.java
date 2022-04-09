package com.ruoyi.project.system.leaveword.controller;

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
import com.ruoyi.project.system.leaveword.domain.Leaveword;
import com.ruoyi.project.system.leaveword.service.ILeavewordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 留言Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/leaveword")
public class LeavewordController extends BaseController
{
    private String prefix = "system/leaveword";

    @Autowired
    private ILeavewordService leavewordService;

    @RequiresPermissions("system:leaveword:view")
    @GetMapping()
    public String leaveword()
    {
        return prefix + "/leaveword";
    }

    /**
     * 查询留言列表
     */
    @RequiresPermissions("system:leaveword:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Leaveword leaveword)
    {
        startPage();
        List<Leaveword> list = leavewordService.selectLeavewordList(leaveword);
        return getDataTable(list);
    }

    /**
     * 导出留言列表
     */
    @RequiresPermissions("system:leaveword:export")
    @Log(title = "留言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Leaveword leaveword)
    {
        List<Leaveword> list = leavewordService.selectLeavewordList(leaveword);
        ExcelUtil<Leaveword> util = new ExcelUtil<Leaveword>(Leaveword.class);
        return util.exportExcel(list, "留言数据");
    }

    /**
     * 新增留言
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存留言
     */
    @RequiresPermissions("system:leaveword:add")
    @Log(title = "留言", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Leaveword leaveword)
    {
        return toAjax(leavewordService.insertLeaveword(leaveword));
    }

    /**
     * 修改留言
     */
    @RequiresPermissions("system:leaveword:edit")
    @GetMapping("/edit/{lwId}")
    public String edit(@PathVariable("lwId") Long lwId, ModelMap mmap)
    {
        Leaveword leaveword = leavewordService.selectLeavewordByLwId(lwId);
        mmap.put("leaveword", leaveword);
        return prefix + "/edit";
    }

    /**
     * 修改保存留言
     */
    @RequiresPermissions("system:leaveword:edit")
    @Log(title = "留言", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Leaveword leaveword)
    {
        return toAjax(leavewordService.updateLeaveword(leaveword));
    }

    /**
     * 删除留言
     */
    @RequiresPermissions("system:leaveword:remove")
    @Log(title = "留言", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(leavewordService.deleteLeavewordByLwIds(ids));
    }
}
