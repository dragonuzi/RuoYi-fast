package com.ruoyi.project.system.news.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 校园新闻对象 comp_news
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class CompNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻id */
    private Long newsId;

    /** 用户ID */
    private Long newsUserid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String newsUsername;

    /** 标题 */
    @Excel(name = "标题")
    private String newsTitle;

    /** 新闻内容 */
    private String newsContent;

    /** 状态 */
    private String newsStatuscode;

    /** 状态 */
    @Excel(name = "状态")
    private String newsStatus;

    /** 排序值 */
    @Excel(name = "排序值")
    private Long newsOrder;

    /** 摘要 */
    private String newsSummary;

    /** 缩略图 */
    private String newsThumbnail;

    /** 删除标记 */
    private Integer delflag;

    /** 创建人 */
    private Long createByid;

    /** 更新人 */
    private Long updateByid;

    public void setNewsId(Long newsId)
    {
        this.newsId = newsId;
    }

    public Long getNewsId()
    {
        return newsId;
    }
    public void setNewsUserid(Long newsUserid)
    {
        this.newsUserid = newsUserid;
    }

    public Long getNewsUserid()
    {
        return newsUserid;
    }
    public void setNewsUsername(String newsUsername)
    {
        this.newsUsername = newsUsername;
    }

    public String getNewsUsername()
    {
        return newsUsername;
    }
    public void setNewsTitle(String newsTitle)
    {
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle()
    {
        return newsTitle;
    }
    public void setNewsContent(String newsContent)
    {
        this.newsContent = newsContent;
    }

    public String getNewsContent()
    {
        return newsContent;
    }
    public void setNewsStatuscode(String newsStatuscode)
    {
        this.newsStatuscode = newsStatuscode;
    }

    public String getNewsStatuscode()
    {
        return newsStatuscode;
    }
    public void setNewsStatus(String newsStatus)
    {
        this.newsStatus = newsStatus;
    }

    public String getNewsStatus()
    {
        return newsStatus;
    }
    public void setNewsOrder(Long newsOrder)
    {
        this.newsOrder = newsOrder;
    }

    public Long getNewsOrder()
    {
        return newsOrder;
    }
    public void setNewsSummary(String newsSummary)
    {
        this.newsSummary = newsSummary;
    }

    public String getNewsSummary()
    {
        return newsSummary;
    }
    public void setNewsThumbnail(String newsThumbnail)
    {
        this.newsThumbnail = newsThumbnail;
    }

    public String getNewsThumbnail()
    {
        return newsThumbnail;
    }
    public void setDelflag(Integer delflag)
    {
        this.delflag = delflag;
    }

    public Integer getDelflag()
    {
        return delflag;
    }
    public void setCreateByid(Long createByid)
    {
        this.createByid = createByid;
    }

    public Long getCreateByid()
    {
        return createByid;
    }
    public void setUpdateByid(Long updateByid)
    {
        this.updateByid = updateByid;
    }

    public Long getUpdateByid()
    {
        return updateByid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsId", getNewsId())
            .append("newsUserid", getNewsUserid())
            .append("newsUsername", getNewsUsername())
            .append("newsTitle", getNewsTitle())
            .append("newsContent", getNewsContent())
            .append("newsStatuscode", getNewsStatuscode())
            .append("newsStatus", getNewsStatus())
            .append("newsOrder", getNewsOrder())
            .append("newsSummary", getNewsSummary())
            .append("newsThumbnail", getNewsThumbnail())
            .append("delflag", getDelflag())
            .append("createByid", getCreateByid())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateByid", getUpdateByid())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
