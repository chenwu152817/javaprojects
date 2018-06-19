package com.javaee.controller;

import com.javaee.dataobject.CourseInfo;
import com.javaee.dataobject.ScInfo;
import com.javaee.dataobject.StudentInfo;
import com.javaee.form.CourseForm;
import com.javaee.form.StudentForm;
import com.javaee.service.CourseInfoService;
import com.javaee.service.ScInfoService;
import com.javaee.service.StudentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentInfoService service;
    @Autowired
    CourseInfoService courseInfoService;
    @Autowired
    ScInfoService scInfoService;
    @PostMapping("/add")
    public ModelAndView add(@Valid StudentForm form,
                            BindingResult bindingResult,
                            Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        StudentInfo studentInfo=service.findOne(form.getStudentId());
        if(studentInfo==null){
            map.put("msg","学生不存在");
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        List<ScInfo> scInfoList=scInfoService.findByCourseId(form.getCourseId());
        List<String> studentIdList=scInfoList.stream().map(e->e.getStudentId()).collect(Collectors.toList());
        if(studentIdList.contains(form.getStudentId())){
            map.put("msg","学生已经存在");
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        ScInfo scInfo1=new ScInfo();
        scInfo1.setCourseId(form.getCourseId());
        scInfo1.setStudentId(form.getStudentId());
        scInfoService.create(scInfo1);
        map.put("msg","添加学生成功");
        map.put("url","/manager/course/detaillist?courseId="+form.getCourseId());
        return new ModelAndView("common/success",map);

    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "courseId",required = false) String courseId
            ,Map<String ,Object> map){
        if(courseId!=null){
            CourseInfo courseInfo=courseInfoService.findOne(courseId);
            map.put("courseInfo",courseInfo);
        }
        return new ModelAndView("/student/index",map);
    }
}
