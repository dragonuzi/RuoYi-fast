package com.ruoyi.project.system.leaveword.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 留言对象 leaveword
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class Leaveword extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 留言id */
    private Long lwId;

    /** 留言学生 */
    private Long lwStuid;

    /** 留言学生 */
    private String lwStuno;

    /** 留言学生 */
    @Excel(name = "留言学生")
    private String lwStuname;

    /** 留言内容 */
    @Excel(name = "留言内容")
    private String lwContent;

    /** 留言时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "留言时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lwLeavetime;

    /** 删除标记 */
    private Integer delflag;

    /** 创建人 */
    private Long createByid;

    /** 更新人 */
    private Long updateByid;

    public void setLwId(Long lwId)
    {
        this.lwId = lwId;
    }

    public Long getLwId()
    {
        return lwId;
    }
    public void setLwStuid(Long lwStuid)
    {
        this.lwStuid = lwStuid;
    }

    public Long getLwStuid()
    {
        return lwStuid;
    }
    public void setLwStuno(String lwStuno)
    {
        this.lwStuno = lwStuno;
    }

    public String getLwStuno()
    {
        return lwStuno;
    }
    public void setLwStuname(String lwStuname)
    {
        this.lwStuname = lwStuname;
    }

    public String getLwStuname()
    {
        return lwStuname;
    }
    public void setLwContent(String lwContent)
    {
        this.lwContent = lwContent;
    }

    public String getLwContent()
    {
        return lwContent;
    }
    public void setLwLeavetime(Date lwLeavetime)
    {
        this.lwLeavetime = lwLeavetime;
    }

    public Date getLwLeavetime()
    {
        return lwLeavetime;
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
            .append("lwId", getLwId())
            .append("lwStuid", getLwStuid())
            .append("lwStuno", getLwStuno())
            .append("lwStuname", getLwStuname())
            .append("lwContent", getLwContent())
            .append("lwLeavetime", getLwLeavetime())
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
