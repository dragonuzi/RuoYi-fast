package com.ruoyi.project.system.major.controller;

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
import com.ruoyi.project.system.major.domain.Major;
import com.ruoyi.project.system.major.service.IMajorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 专业信息Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/major")
public class MajorController extends BaseController
{
    private String prefix = "system/major";

    @Autowired
    private IMajorService majorService;

    @RequiresPermissions("system:major:view")
    @GetMapping()
    public String major()
    {
        return prefix + "/major";
    }

    /**
     * 查询专业信息列表
     */
    @RequiresPermissions("system:major:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Major major)
    {
        startPage();
        List<Major> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 导出专业信息列表
     */
    @RequiresPermissions("system:major:export")
    @Log(title = "专业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Major major)
    {
        List<Major> list = majorService.selectMajorList(major);
        ExcelUtil<Major> util = new ExcelUtil<Major>(Major.class);
        return util.exportExcel(list, "专业信息数据");
    }

    /**
     * 新增专业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专业信息
     */
    @RequiresPermissions("system:major:add")
    @Log(title = "专业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Major major)
    {
        return toAjax(majorService.insertMajor(major));
    }

    /**
     * 修改专业信息
     */
    @RequiresPermissions("system:major:edit")
    @GetMapping("/edit/{majorId}")
    public String edit(@PathVariable("majorId") Long majorId, ModelMap mmap)
    {
        Major major = majorService.selectMajorByMajorId(majorId);
        mmap.put("major", major);
        return prefix + "/edit";
    }

    /**
     * 修改保存专业信息
     */
    @RequiresPermissions("system:major:edit")
    @Log(title = "专业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Major major)
    {
        return toAjax(majorService.updateMajor(major));
    }

    /**
     * 删除专业信息
     */
    @RequiresPermissions("system:major:remove")
    @Log(title = "专业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(majorService.deleteMajorByMajorIds(ids));
    }
}
