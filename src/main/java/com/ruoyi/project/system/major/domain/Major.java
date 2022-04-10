package com.ruoyi.project.system.major.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 专业信息对象 major
 *
 * @author ruoyi
 * @date 2022-04-10
 */
public class Major extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业id */
    private Long majorId;

    /** 专业代码 */
    @Excel(name = "专业代码")
    private String majorCode;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String majorName;

    /** 专业描述 */
    private String majorDescription;

    /** 删除标记 */
    private Integer delflag;

    /** 创建人id */
    private Long createByid;

    /** 更新人id */
    private Long updateByid;

    public void setMajorId(Long majorId)
    {
        this.majorId = majorId;
    }

    public Long getMajorId()
    {
        return majorId;
    }
    public void setMajorCode(String majorCode)
    {
        this.majorCode = majorCode;
    }

    public String getMajorCode()
    {
        return majorCode;
    }
    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }

    public String getMajorName()
    {
        return majorName;
    }
    public void setMajorDescription(String majorDescription)
    {
        this.majorDescription = majorDescription;
    }

    public String getMajorDescription()
    {
        return majorDescription;
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
                .append("majorId", getMajorId())
                .append("majorCode", getMajorCode())
                .append("majorName", getMajorName())
                .append("majorDescription", getMajorDescription())
                .append("remark", getRemark())
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
