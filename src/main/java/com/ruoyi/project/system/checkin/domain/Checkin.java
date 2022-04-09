package com.ruoyi.project.system.checkin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 新生报到记录对象 checkin
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class Checkin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报到记录id */
    private Long checkinId;

    /** 报到学生 */
    private Long checkinStuid;

    /** 报到学生 */
    private String checkinStuno;

    /** 报到学生 */
    @Excel(name = "报到学生")
    private String checkinStuname;

    /** 专业 */
    private Long checkinMajorid;

    /** 专业 */
    @Excel(name = "专业")
    private String checkinMajor;

    /** 班级 */
    private Long checkinClassid;

    /** 删除标记 */
    private Integer delflag;

    /** 报到时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报到时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkinTime;

    /** 创建人 */
    private Long createByid;

    /** 班级 */
    @Excel(name = "班级")
    private String checkinClass;

    /** 更新人 */
    private Long updateByid;

    public void setCheckinId(Long checkinId)
    {
        this.checkinId = checkinId;
    }

    public Long getCheckinId()
    {
        return checkinId;
    }
    public void setCheckinStuid(Long checkinStuid)
    {
        this.checkinStuid = checkinStuid;
    }

    public Long getCheckinStuid()
    {
        return checkinStuid;
    }
    public void setCheckinStuno(String checkinStuno)
    {
        this.checkinStuno = checkinStuno;
    }

    public String getCheckinStuno()
    {
        return checkinStuno;
    }
    public void setCheckinStuname(String checkinStuname)
    {
        this.checkinStuname = checkinStuname;
    }

    public String getCheckinStuname()
    {
        return checkinStuname;
    }
    public void setCheckinMajorid(Long checkinMajorid)
    {
        this.checkinMajorid = checkinMajorid;
    }

    public Long getCheckinMajorid()
    {
        return checkinMajorid;
    }
    public void setCheckinMajor(String checkinMajor)
    {
        this.checkinMajor = checkinMajor;
    }

    public String getCheckinMajor()
    {
        return checkinMajor;
    }
    public void setCheckinClassid(Long checkinClassid)
    {
        this.checkinClassid = checkinClassid;
    }

    public Long getCheckinClassid()
    {
        return checkinClassid;
    }
    public void setDelflag(Integer delflag)
    {
        this.delflag = delflag;
    }

    public Integer getDelflag()
    {
        return delflag;
    }
    public void setCheckinTime(Date checkinTime)
    {
        this.checkinTime = checkinTime;
    }

    public Date getCheckinTime()
    {
        return checkinTime;
    }
    public void setCreateByid(Long createByid)
    {
        this.createByid = createByid;
    }

    public Long getCreateByid()
    {
        return createByid;
    }
    public void setCheckinClass(String checkinClass)
    {
        this.checkinClass = checkinClass;
    }

    public String getCheckinClass()
    {
        return checkinClass;
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
            .append("checkinId", getCheckinId())
            .append("checkinStuid", getCheckinStuid())
            .append("checkinStuno", getCheckinStuno())
            .append("checkinStuname", getCheckinStuname())
            .append("checkinMajorid", getCheckinMajorid())
            .append("checkinMajor", getCheckinMajor())
            .append("checkinClassid", getCheckinClassid())
            .append("delflag", getDelflag())
            .append("checkinTime", getCheckinTime())
            .append("createByid", getCreateByid())
            .append("checkinClass", getCheckinClass())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateByid", getUpdateByid())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
