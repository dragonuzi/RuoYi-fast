package com.ruoyi.project.system.checkin.controller;

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
import com.ruoyi.project.system.checkin.domain.Checkin;
import com.ruoyi.project.system.checkin.service.ICheckinService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 新生报到记录Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/checkin")
public class CheckinController extends BaseController
{
    private String prefix = "system/checkin";

    @Autowired
    private ICheckinService checkinService;

    @RequiresPermissions("system:checkin:view")
    @GetMapping()
    public String checkin()
    {
        return prefix + "/checkin";
    }

    /**
     * 查询新生报到记录列表
     */
    @RequiresPermissions("system:checkin:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Checkin checkin)
    {
        startPage();
        List<Checkin> list = checkinService.selectCheckinList(checkin);
        return getDataTable(list);
    }

    /**
     * 导出新生报到记录列表
     */
    @RequiresPermissions("system:checkin:export")
    @Log(title = "新生报到记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Checkin checkin)
    {
        List<Checkin> list = checkinService.selectCheckinList(checkin);
        ExcelUtil<Checkin> util = new ExcelUtil<Checkin>(Checkin.class);
        return util.exportExcel(list, "新生报到记录数据");
    }

    /**
     * 新增新生报到记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新生报到记录
     */
    @RequiresPermissions("system:checkin:add")
    @Log(title = "新生报到记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Checkin checkin)
    {
        return toAjax(checkinService.insertCheckin(checkin));
    }

    /**
     * 修改新生报到记录
     */
    @RequiresPermissions("system:checkin:edit")
    @GetMapping("/edit/{checkinId}")
    public String edit(@PathVariable("checkinId") Long checkinId, ModelMap mmap)
    {
        Checkin checkin = checkinService.selectCheckinByCheckinId(checkinId);
        mmap.put("checkin", checkin);
        return prefix + "/edit";
    }

    /**
     * 修改保存新生报到记录
     */
    @RequiresPermissions("system:checkin:edit")
    @Log(title = "新生报到记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Checkin checkin)
    {
        return toAjax(checkinService.updateCheckin(checkin));
    }

    /**
     * 删除新生报到记录
     */
    @RequiresPermissions("system:checkin:remove")
    @Log(title = "新生报到记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(checkinService.deleteCheckinByCheckinIds(ids));
    }
}
