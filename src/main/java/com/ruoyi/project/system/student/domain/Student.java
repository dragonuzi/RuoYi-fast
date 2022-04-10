package com.ruoyi.project.system.student.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学生信息对象 student
 *
 * @author ruoyi
 * @date 2022-04-10
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生id */
    private Long stuId;

    /** 用户名 */
    private Long stuUserid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String stuUsername;

    /** 学号 */
    @Excel(name = "学号")
    private String stuNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String stuName;

    /** 性别 */
    @Excel(name = "性别")
    private String stuGender;

    /** 手机号 */
    @Excel(name = "手机号")
    private String stuPhoneno;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String stuIdcardno;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String stuAddress;

    /** 专业 */
    private Long stuMajorid;

    /** 专业 */
    @Excel(name = "专业")
    private String stuMajor;

    /** 班级 */
    private Long stuClassid;

    /** 班级 */
    @Excel(name = "班级")
    private String stuClass;

    /** 宿舍 */
    private Long stuDormitoryid;

    /** 宿舍 */
    @Excel(name = "宿舍")
    private String stuDormitory;

    /** 状态 */
    @Excel(name = "状态")
    private String stuStatuscode;

    /** 状态 */
    private String stuStatus;

    /** 是否删除 */
    private Integer delflag;

    /** 创建人id */
    private Long createByid;

    /** 更新人id */
    private Long updateByid;

    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setStuUserid(Long stuUserid)
    {
        this.stuUserid = stuUserid;
    }

    public Long getStuUserid()
    {
        return stuUserid;
    }
    public void setStuUsername(String stuUsername)
    {
        this.stuUsername = stuUsername;
    }

    public String getStuUsername()
    {
        return stuUsername;
    }
    public void setStuNo(String stuNo)
    {
        this.stuNo = stuNo;
    }

    public String getStuNo()
    {
        return stuNo;
    }
    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuName()
    {
        return stuName;
    }
    public void setStuGender(String stuGender)
    {
        this.stuGender = stuGender;
    }

    public String getStuGender()
    {
        return stuGender;
    }
    public void setStuPhoneno(String stuPhoneno)
    {
        this.stuPhoneno = stuPhoneno;
    }

    public String getStuPhoneno()
    {
        return stuPhoneno;
    }
    public void setStuIdcardno(String stuIdcardno)
    {
        this.stuIdcardno = stuIdcardno;
    }

    public String getStuIdcardno()
    {
        return stuIdcardno;
    }
    public void setStuAddress(String stuAddress)
    {
        this.stuAddress = stuAddress;
    }

    public String getStuAddress()
    {
        return stuAddress;
    }
    public void setStuMajorid(Long stuMajorid)
    {
        this.stuMajorid = stuMajorid;
    }

    public Long getStuMajorid()
    {
        return stuMajorid;
    }
    public void setStuMajor(String stuMajor)
    {
        this.stuMajor = stuMajor;
    }

    public String getStuMajor()
    {
        return stuMajor;
    }
    public void setStuClassid(Long stuClassid)
    {
        this.stuClassid = stuClassid;
    }

    public Long getStuClassid()
    {
        return stuClassid;
    }
    public void setStuClass(String stuClass)
    {
        this.stuClass = stuClass;
    }

    public String getStuClass()
    {
        return stuClass;
    }
    public void setStuDormitoryid(Long stuDormitoryid)
    {
        this.stuDormitoryid = stuDormitoryid;
    }

    public Long getStuDormitoryid()
    {
        return stuDormitoryid;
    }
    public void setStuDormitory(String stuDormitory)
    {
        this.stuDormitory = stuDormitory;
    }

    public String getStuDormitory()
    {
        return stuDormitory;
    }
    public void setStuStatuscode(String stuStatuscode)
    {
        this.stuStatuscode = stuStatuscode;
    }

    public String getStuStatuscode()
    {
        return stuStatuscode;
    }
    public void setStuStatus(String stuStatus)
    {
        this.stuStatus = stuStatus;
    }

    public String getStuStatus()
    {
        return stuStatus;
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
                .append("stuId", getStuId())
                .append("stuUserid", getStuUserid())
                .append("stuUsername", getStuUsername())
                .append("stuNo", getStuNo())
                .append("stuName", getStuName())
                .append("stuGender", getStuGender())
                .append("stuPhoneno", getStuPhoneno())
                .append("stuIdcardno", getStuIdcardno())
                .append("stuAddress", getStuAddress())
                .append("stuMajorid", getStuMajorid())
                .append("stuMajor", getStuMajor())
                .append("stuClassid", getStuClassid())
                .append("stuClass", getStuClass())
                .append("stuDormitoryid", getStuDormitoryid())
                .append("stuDormitory", getStuDormitory())
                .append("stuStatuscode", getStuStatuscode())
                .append("stuStatus", getStuStatus())
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
