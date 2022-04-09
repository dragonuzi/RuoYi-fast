package com.ruoyi.project.system.class1.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 班级对象 class1
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class Class1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级id */
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 专业 */
    private Long classMajorid;

    /** 专业 */
    @Excel(name = "专业")
    private String classMajor;

    /** 删除标记 */
    private String delflag;

    /** 创建人id */
    private Long createByid;

    /** 更新人id */
    private Long updateByid;

    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public Long getClassId()
    {
        return classId;
    }
    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassName()
    {
        return className;
    }
    public void setClassMajorid(Long classMajorid)
    {
        this.classMajorid = classMajorid;
    }

    public Long getClassMajorid()
    {
        return classMajorid;
    }
    public void setClassMajor(String classMajor)
    {
        this.classMajor = classMajor;
    }

    public String getClassMajor()
    {
        return classMajor;
    }
    public void setDelflag(String delflag)
    {
        this.delflag = delflag;
    }

    public String getDelflag()
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
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("classMajorid", getClassMajorid())
            .append("classMajor", getClassMajor())
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
