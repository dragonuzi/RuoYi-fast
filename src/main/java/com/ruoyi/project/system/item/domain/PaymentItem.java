package com.ruoyi.project.system.item.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 缴费项目对象 payment_item
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class PaymentItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缴费项id */
    private Long piId;

    /** 缴费项 */
    @Excel(name = "缴费项")
    private String piName;

    /** 缴费金额 */
    @Excel(name = "缴费金额")
    private BigDecimal piAmount;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date piDeadline;

    /** 删除标记 */
    private Integer delflag;

    /** 创建人 */
    private Long createByid;

    /** 更新人 */
    private Long updateByid;

    public void setPiId(Long piId)
    {
        this.piId = piId;
    }

    public Long getPiId()
    {
        return piId;
    }
    public void setPiName(String piName)
    {
        this.piName = piName;
    }

    public String getPiName()
    {
        return piName;
    }
    public void setPiAmount(BigDecimal piAmount)
    {
        this.piAmount = piAmount;
    }

    public BigDecimal getPiAmount()
    {
        return piAmount;
    }
    public void setPiDeadline(Date piDeadline)
    {
        this.piDeadline = piDeadline;
    }

    public Date getPiDeadline()
    {
        return piDeadline;
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
            .append("piId", getPiId())
            .append("piName", getPiName())
            .append("piAmount", getPiAmount())
            .append("piDeadline", getPiDeadline())
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
