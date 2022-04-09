package com.ruoyi.project.system.dormitory.controller;

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
import com.ruoyi.project.system.dormitory.domain.Dormitory;
import com.ruoyi.project.system.dormitory.service.IDormitoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 宿舍信息Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/dormitory")
public class DormitoryController extends BaseController
{
    private String prefix = "system/dormitory";

    @Autowired
    private IDormitoryService dormitoryService;

    @RequiresPermissions("system:dormitory:view")
    @GetMapping()
    public String dormitory()
    {
        return prefix + "/dormitory";
    }

    /**
     * 查询宿舍信息树列表
     */
    @RequiresPermissions("system:dormitory:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Dormitory> list(Dormitory dormitory)
    {
        List<Dormitory> list = dormitoryService.selectDormitoryList(dormitory);
        return list;
    }

    /**
     * 导出宿舍信息列表
     */
    @RequiresPermissions("system:dormitory:export")
    @Log(title = "宿舍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dormitory dormitory)
    {
        List<Dormitory> list = dormitoryService.selectDormitoryList(dormitory);
        ExcelUtil<Dormitory> util = new ExcelUtil<Dormitory>(Dormitory.class);
        return util.exportExcel(list, "宿舍信息数据");
    }

    /**
     * 新增宿舍信息
     */
    @GetMapping(value = { "/add/{dorId}", "/add/" })
    public String add(@PathVariable(value = "dorId", required = false) Long dorId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(dorId))
        {
            mmap.put("dormitory", dormitoryService.selectDormitoryByDorId(dorId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍信息
     */
    @RequiresPermissions("system:dormitory:add")
    @Log(title = "宿舍信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dormitory dormitory)
    {
        return toAjax(dormitoryService.insertDormitory(dormitory));
    }

    /**
     * 修改宿舍信息
     */
    @RequiresPermissions("system:dormitory:edit")
    @GetMapping("/edit/{dorId}")
    public String edit(@PathVariable("dorId") Long dorId, ModelMap mmap)
    {
        Dormitory dormitory = dormitoryService.selectDormitoryByDorId(dorId);
        mmap.put("dormitory", dormitory);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍信息
     */
    @RequiresPermissions("system:dormitory:edit")
    @Log(title = "宿舍信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dormitory dormitory)
    {
        return toAjax(dormitoryService.updateDormitory(dormitory));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:dormitory:remove")
    @Log(title = "宿舍信息", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{dorId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("dorId") Long dorId)
    {
        return toAjax(dormitoryService.deleteDormitoryByDorId(dorId));
    }

    /**
     * 选择宿舍信息树
     */
    @GetMapping(value = { "/selectDormitoryTree/{dorId}", "/selectDormitoryTree/" })
    public String selectDormitoryTree(@PathVariable(value = "dorId", required = false) Long dorId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(dorId))
        {
            mmap.put("dormitory", dormitoryService.selectDormitoryByDorId(dorId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载宿舍信息树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = dormitoryService.selectDormitoryTree();
        return ztrees;
    }
}
