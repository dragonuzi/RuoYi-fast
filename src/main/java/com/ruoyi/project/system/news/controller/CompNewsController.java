package com.ruoyi.project.system.news.controller;

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
import com.ruoyi.project.system.news.domain.CompNews;
import com.ruoyi.project.system.news.service.ICompNewsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 校园新闻Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/news")
public class CompNewsController extends BaseController
{
    private String prefix = "system/news";

    @Autowired
    private ICompNewsService compNewsService;

    @RequiresPermissions("system:news:view")
    @GetMapping()
    public String news()
    {
        return prefix + "/news";
    }

    /**
     * 查询校园新闻列表
     */
    @RequiresPermissions("system:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompNews compNews)
    {
        startPage();
        List<CompNews> list = compNewsService.selectCompNewsList(compNews);
        return getDataTable(list);
    }

    /**
     * 导出校园新闻列表
     */
    @RequiresPermissions("system:news:export")
    @Log(title = "校园新闻", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompNews compNews)
    {
        List<CompNews> list = compNewsService.selectCompNewsList(compNews);
        ExcelUtil<CompNews> util = new ExcelUtil<CompNews>(CompNews.class);
        return util.exportExcel(list, "校园新闻数据");
    }

    /**
     * 新增校园新闻
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存校园新闻
     */
    @RequiresPermissions("system:news:add")
    @Log(title = "校园新闻", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompNews compNews)
    {
        return toAjax(compNewsService.insertCompNews(compNews));
    }

    /**
     * 修改校园新闻
     */
    @RequiresPermissions("system:news:edit")
    @GetMapping("/edit/{newsId}")
    public String edit(@PathVariable("newsId") Long newsId, ModelMap mmap)
    {
        CompNews compNews = compNewsService.selectCompNewsByNewsId(newsId);
        mmap.put("compNews", compNews);
        return prefix + "/edit";
    }

    /**
     * 修改保存校园新闻
     */
    @RequiresPermissions("system:news:edit")
    @Log(title = "校园新闻", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompNews compNews)
    {
        return toAjax(compNewsService.updateCompNews(compNews));
    }

    /**
     * 删除校园新闻
     */
    @RequiresPermissions("system:news:remove")
    @Log(title = "校园新闻", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(compNewsService.deleteCompNewsByNewsIds(ids));
    }
}
