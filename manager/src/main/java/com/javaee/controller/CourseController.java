package com.javaee.controller;

import com.javaee.ResultVO.CourseResultVO;
import com.javaee.dataobject.CourseInfo;
import com.javaee.dataobject.ScInfo;
import com.javaee.dataobject.StudentInfo;
import com.javaee.exception.ManagerException;
import com.javaee.form.CourseForm;
import com.javaee.form.ScForm;
import com.javaee.form.StudentForm;
import com.javaee.repository.ScInfoRepository;
import com.javaee.service.CourseInfoService;
import com.javaee.service.ScInfoService;
import com.javaee.service.StudentInfoService;
import com.javaee.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/course")
public class CourseController {
    @Autowired
    ScInfoRepository repository;
    @Autowired
    private CourseInfoService service;
    @Autowired
    private ScInfoService scInfoService;
    @Autowired
    private StudentInfoService studentInfoService;
    @GetMapping("/list")
    public ModelAndView list(//@RequestParam("teacherId") String teacherId,
                             HttpServletRequest request,
                             Map<String ,Object> map){
        String teacherId= CookieUtil.get(request,"token").getValue();
        List<CourseInfo> courseInfoList=service.findByTeacherId(teacherId);
        map.put("courseInfoList",courseInfoList);
        return new ModelAndView("/course/list",map);

    }
    @GetMapping("/detaillists")
    public ModelAndView detaillists(@RequestParam("courseId") String courseId,
                                    @RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "size",defaultValue = "2") Integer size,
                                   Map<String,Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        CourseInfo courseInfo=service.findOne(courseId);
        Page<StudentForm> studentInfoPage=studentInfoService
                .findByStudentId(courseId,request);
        map.put("courseInfo",courseInfo);
        map.put("studentInfoPage",studentInfoPage);
        map.put("currentPage",page);
        return new ModelAndView("/course/detaillists",map);
    }
    @GetMapping("/detaillist")
    public ModelAndView detaillist(@RequestParam("courseId") String courseId,
                                   Map<String ,Object> map){
        CourseInfo courseInfo=service.findOne(courseId);
        String courseName=courseInfo.getCourseName();
        List<ScForm> scFormList=new ArrayList<>();
        List<ScInfo> scInfoList=scInfoService.findByCourseId(courseId);
        for(ScInfo scInfo:scInfoList){
            ScForm scForm=new ScForm();
            BeanUtils.copyProperties(scInfo,scForm);
            scForm.setStudentName(studentInfoService.findOne(scForm.getStudentId()).getStudentName());
            scFormList.add(scForm);
        }
        /*List<String> studentList =
                scInfoList.stream()
                        .map(e->e.getStudentId())
                        .collect(Collectors.toList());
        List<StudentInfo> studentInfoList=studentInfoService
                .findByStudentIdIn(studentList);*/
        map.put("courseInfo",courseInfo);
        map.put("scFormList",scFormList);

        return new ModelAndView("/course/detaillist",map);

    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "courseId",required = false) String courseId
                                ,Map<String ,Object> map){
        if(courseId!=null){
            CourseInfo courseInfo=service.findOne(courseId);
            map.put("courseInfo",courseInfo);
        }
        return new ModelAndView("/course/index",map);
    }
    @GetMapping("/index1")
    public ModelAndView index1(){
        return new ModelAndView("/course/index1");
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid CourseForm form,
                             HttpServletRequest request,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        CourseInfo courseInfo=new CourseInfo();
        try {
            if(form.getCourseId()!=null){
                courseInfo=service.findOne(form.getCourseId());
            }
            BeanUtils.copyProperties(form,courseInfo);
            courseInfo.setTeacherId(CookieUtil.get(request,"token").getValue());
            service.save(courseInfo);
        }catch (ManagerException e){
            map.put("msg",e.getMessage());
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg","创建/修改课程成功");
        map.put("url","/manager/course/list");
        return new ModelAndView("common/success",map);
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid CourseForm form,
                               HttpServletRequest request,
                               BindingResult bindingResult,
                               Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        if(form.getCourseName()==""||form.getCourseIntro()==""||form.getCourseId()==""){
            map.put("msg","课程信息不完整");
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        CourseInfo courseInfo=new CourseInfo();
        try {
            if(form.getCourseId()!=null){
                courseInfo=service.findOne(form.getCourseId());
                if(courseInfo!=null){
                    map.put("msg","课程已经存在");
                    map.put("url","/manager/course/list");
                    return new ModelAndView("common/error",map);
                }
            }
            CourseInfo courseInfo1=new CourseInfo();
            BeanUtils.copyProperties(form,courseInfo1);
            courseInfo1.setTeacherId(CookieUtil.get(request,"token").getValue());
            service.save(courseInfo1);
        }catch (ManagerException e){
            map.put("msg",e.getMessage());
            map.put("url","/manager/course/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg","创建/修改课程成功");
        map.put("url","/manager/course/list");
        return new ModelAndView("common/success",map);
    }
}
