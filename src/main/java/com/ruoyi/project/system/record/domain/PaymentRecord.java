package com.ruoyi.project.system.record.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 缴费记录对象 payment_record
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
public class PaymentRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缴费记录id */
    private Long prId;

    /** 缴费项 */
    private Long prPiid;

    /** 缴费项 */
    @Excel(name = "缴费项")
    private String prPiname;

    /** 缴费学生 */
    private Long prStuid;

    /** 缴费学生 */
    private String prStuno;

    /** 缴费人 */
    @Excel(name = "缴费人")
    private String prStuname;

    /** 缴费时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "缴费时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date prPaytime;

    /** 删除标记 */
    private String delflag;

    /** 创建人 */
    private Long createByid;

    /** 更新人 */
    private Long updateByid;

    public void setPrId(Long prId)
    {
        this.prId = prId;
    }

    public Long getPrId()
    {
        return prId;
    }
    public void setPrPiid(Long prPiid)
    {
        this.prPiid = prPiid;
    }

    public Long getPrPiid()
    {
        return prPiid;
    }
    public void setPrPiname(String prPiname)
    {
        this.prPiname = prPiname;
    }

    public String getPrPiname()
    {
        return prPiname;
    }
    public void setPrStuid(Long prStuid)
    {
        this.prStuid = prStuid;
    }

    public Long getPrStuid()
    {
        return prStuid;
    }
    public void setPrStuno(String prStuno)
    {
        this.prStuno = prStuno;
    }

    public String getPrStuno()
    {
        return prStuno;
    }
    public void setPrStuname(String prStuname)
    {
        this.prStuname = prStuname;
    }

    public String getPrStuname()
    {
        return prStuname;
    }
    public void setPrPaytime(Date prPaytime)
    {
        this.prPaytime = prPaytime;
    }

    public Date getPrPaytime()
    {
        return prPaytime;
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
            .append("prId", getPrId())
            .append("prPiid", getPrPiid())
            .append("prPiname", getPrPiname())
            .append("prStuid", getPrStuid())
            .append("prStuno", getPrStuno())
            .append("prStuname", getPrStuname())
            .append("prPaytime", getPrPaytime())
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
