package com.ruoyi.project.system.dormitory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 宿舍信息对象 dormitory
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class Dormitory extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍id */
    private Long dorId;

    /** 父级 */
    private String dorParentid;

    /** 宿舍号 */
    @Excel(name = "宿舍号")
    private String dorNo;

    /** 宿舍名称 */
    @Excel(name = "宿舍名称")
    private String dorName;

    /** 床位数 */
    @Excel(name = "床位数")
    private Long dorBeds;

    /** 宿舍描述 */
    private String dorDescription;

    /** 删除标记 */
    private Integer delflag;

    /** 创建人id */
    private Long createByid;

    /** 更新人id */
    private Long updateByid;

    public void setDorId(Long dorId)
    {
        this.dorId = dorId;
    }

    public Long getDorId()
    {
        return dorId;
    }
    public void setDorParentid(String dorParentid)
    {
        this.dorParentid = dorParentid;
    }

    public String getDorParentid()
    {
        return dorParentid;
    }
    public void setDorNo(String dorNo)
    {
        this.dorNo = dorNo;
    }

    public String getDorNo()
    {
        return dorNo;
    }
    public void setDorName(String dorName)
    {
        this.dorName = dorName;
    }

    public String getDorName()
    {
        return dorName;
    }
    public void setDorBeds(Long dorBeds)
    {
        this.dorBeds = dorBeds;
    }

    public Long getDorBeds()
    {
        return dorBeds;
    }
    public void setDorDescription(String dorDescription)
    {
        this.dorDescription = dorDescription;
    }

    public String getDorDescription()
    {
        return dorDescription;
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
            .append("dorId", getDorId())
            .append("dorParentid", getDorParentid())
            .append("dorNo", getDorNo())
            .append("dorName", getDorName())
            .append("dorBeds", getDorBeds())
            .append("dorDescription", getDorDescription())
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
