package com.ruoyi.project.system.news.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.news.mapper.CompNewsMapper;
import com.ruoyi.project.system.news.domain.CompNews;
import com.ruoyi.project.system.news.service.ICompNewsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 校园新闻Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Service
public class CompNewsServiceImpl implements ICompNewsService 
{
    @Autowired
    private CompNewsMapper compNewsMapper;

    /**
     * 查询校园新闻
     * 
     * @param newsId 校园新闻主键
     * @return 校园新闻
     */
    @Override
    public CompNews selectCompNewsByNewsId(Long newsId)
    {
        return compNewsMapper.selectCompNewsByNewsId(newsId);
    }

    /**
     * 查询校园新闻列表
     * 
     * @param compNews 校园新闻
     * @return 校园新闻
     */
    @Override
    public List<CompNews> selectCompNewsList(CompNews compNews)
    {
        return compNewsMapper.selectCompNewsList(compNews);
    }

    /**
     * 新增校园新闻
     * 
     * @param compNews 校园新闻
     * @return 结果
     */
    @Override
    public int insertCompNews(CompNews compNews)
    {
        compNews.setCreateTime(DateUtils.getNowDate());
        return compNewsMapper.insertCompNews(compNews);
    }

    /**
     * 修改校园新闻
     * 
     * @param compNews 校园新闻
     * @return 结果
     */
    @Override
    public int updateCompNews(CompNews compNews)
    {
        compNews.setUpdateTime(DateUtils.getNowDate());
        return compNewsMapper.updateCompNews(compNews);
    }

    /**
     * 批量删除校园新闻
     * 
     * @param newsIds 需要删除的校园新闻主键
     * @return 结果
     */
    @Override
    public int deleteCompNewsByNewsIds(String newsIds)
    {
        return compNewsMapper.deleteCompNewsByNewsIds(Convert.toStrArray(newsIds));
    }

    /**
     * 删除校园新闻信息
     * 
     * @param newsId 校园新闻主键
     * @return 结果
     */
    @Override
    public int deleteCompNewsByNewsId(Long newsId)
    {
        return compNewsMapper.deleteCompNewsByNewsId(newsId);
    }
}
