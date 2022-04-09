package com.ruoyi.project.system.class1.controller;

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
import com.ruoyi.project.system.class1.domain.Class1;
import com.ruoyi.project.system.class1.service.IClass1Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 班级Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/class1")
public class Class1Controller extends BaseController
{
    private String prefix = "system/class1";

    @Autowired
    private IClass1Service class1Service;

    @RequiresPermissions("system:class1:view")
    @GetMapping()
    public String class1()
    {
        return prefix + "/class1";
    }

    /**
     * 查询班级列表
     */
    @RequiresPermissions("system:class1:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Class1 class1)
    {
        startPage();
        List<Class1> list = class1Service.selectClass1List(class1);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @RequiresPermissions("system:class1:export")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Class1 class1)
    {
        List<Class1> list = class1Service.selectClass1List(class1);
        ExcelUtil<Class1> util = new ExcelUtil<Class1>(Class1.class);
        return util.exportExcel(list, "班级数据");
    }

    /**
     * 新增班级
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存班级
     */
    @RequiresPermissions("system:class1:add")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Class1 class1)
    {
        return toAjax(class1Service.insertClass1(class1));
    }

    /**
     * 修改班级
     */
    @RequiresPermissions("system:class1:edit")
    @GetMapping("/edit/{classId}")
    public String edit(@PathVariable("classId") Long classId, ModelMap mmap)
    {
        Class1 class1 = class1Service.selectClass1ByClassId(classId);
        mmap.put("class1", class1);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级
     */
    @RequiresPermissions("system:class1:edit")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Class1 class1)
    {
        return toAjax(class1Service.updateClass1(class1));
    }

    /**
     * 删除班级
     */
    @RequiresPermissions("system:class1:remove")
    @Log(title = "班级", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(class1Service.deleteClass1ByClassIds(ids));
    }
}
