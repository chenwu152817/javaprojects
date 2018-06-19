package com.javaee.controller;

import com.javaee.ResultVO.CourseResultVO;
import com.javaee.dataobject.ScInfo;
import com.javaee.repository.ScInfoRepository;
import com.javaee.service.ScInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/sc")
public class ScController {
    @Autowired
    private ScInfoService scInfoService;
    @Autowired
    private ScInfoRepository repository;
    @PostMapping("/savegrade")
    @ResponseBody
    public CourseResultVO savegrade(@RequestParam("scId") Integer scId,
                                    @RequestParam("testGrade") Integer testGrade,
                                    @RequestParam("courseGrade") Integer courseGrade){
        System.out.println(""+scId+""+testGrade+""+courseGrade);
        ScInfo scInfo=scInfoService.findOne(scId);
        System.out.println(scId+testGrade+courseGrade);
        if(testGrade==null||courseGrade==null){
            CourseResultVO courseResultVO=new CourseResultVO();
            courseResultVO.setSuccess(false);
            courseResultVO.setMsg("数据不能为空");
            return courseResultVO;
        }
        scInfo.setCourseGrade(courseGrade);
        scInfo.setTestGrade(testGrade);
        scInfoService.save(scInfo);
        CourseResultVO courseResultVO=new CourseResultVO();
        courseResultVO.setSuccess(true);
        courseResultVO.setMsg("保存成功");
        courseResultVO.setCourseGrade(courseGrade);
        courseResultVO.setTestGrade(testGrade);
        return courseResultVO;

    }
    @GetMapping("/delete")
    @Transactional
    public String delete(@RequestParam("courseId") String courseId,
                               @RequestParam("scId") Integer scId
                                   ){
        ScInfo scInfo=scInfoService.findOne(scId);
        repository.delete(scInfo);
        return "redirect:"+"http://localhost:8080/manager/course/detaillist?courseId="+courseId;
    }
}
