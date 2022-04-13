package com.ruoyi.project.system.student.controller;

import java.util.List;

import com.ruoyi.project.system.class1.domain.Class1;
import com.ruoyi.project.system.class1.service.IClass1Service;
import com.ruoyi.project.system.major.domain.Major;
import com.ruoyi.project.system.major.service.IMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.student.domain.Student;
import com.ruoyi.project.system.student.service.IStudentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author ruoyi
 * @date 2022-04-09
 */
@Controller
@RequestMapping("/system/student")
public class StudentController extends BaseController
{
    private String prefix = "system/student";

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IMajorService majorService;
    @Autowired
    private IClass1Service class1Service;
    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学生信息列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student)
    {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Student student)
    {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list, "学生信息数据");
    }

    /**
     * 新增学生信息
     */
    @GetMapping("/add")
    public String add()
    {
        //采取planb，学生信息不允许增删，新增学生用户时自动添加
        //需要提供未注册学生信息的学生角色用户
        //所有的专业列表
        //所有的班级列表(下一步考虑实现专业和班级的互动)

        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Student student)
    {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改学生信息
     */
    @RequiresPermissions("system:student:edit")
    @GetMapping("/edit/{stuId}")
    public String edit(@PathVariable("stuId") Long stuId, ModelMap mmap)
    {
        Student student = studentService.selectStudentByStuId(stuId);
        mmap.put("student", student);
        //后续考虑处理专业班级的联动
        List<Major> majors=majorService.selectMajorList(new Major());
        mmap.put("majors",majors);
        List<Class1> classes=class1Service.selectClass1List(new Class1());
        mmap.put("classes",classes);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student student)
    {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentService.deleteStudentByStuIds(ids));
    }
}
