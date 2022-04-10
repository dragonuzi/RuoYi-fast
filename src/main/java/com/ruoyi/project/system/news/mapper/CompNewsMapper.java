package com.ruoyi.project.system.news.mapper;

import java.util.List;
import com.ruoyi.project.system.news.domain.CompNews;
import org.springframework.stereotype.Repository;

/**
 * 校园新闻Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Repository
public interface CompNewsMapper 
{
    /**
     * 查询校园新闻
     * 
     * @param newsId 校园新闻主键
     * @return 校园新闻
     */
    public CompNews selectCompNewsByNewsId(Long newsId);

    /**
     * 查询校园新闻列表
     * 
     * @param compNews 校园新闻
     * @return 校园新闻集合
     */
    public List<CompNews> selectCompNewsList(CompNews compNews);

    /**
     * 新增校园新闻
     * 
     * @param compNews 校园新闻
     * @return 结果
     */
    public int insertCompNews(CompNews compNews);

    /**
     * 修改校园新闻
     * 
     * @param compNews 校园新闻
     * @return 结果
     */
    public int updateCompNews(CompNews compNews);

    /**
     * 删除校园新闻
     * 
     * @param newsId 校园新闻主键
     * @return 结果
     */
    public int deleteCompNewsByNewsId(Long newsId);

    /**
     * 批量删除校园新闻
     * 
     * @param newsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompNewsByNewsIds(String[] newsIds);
}
