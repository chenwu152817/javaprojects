package com.javaee.controller;

import com.javaee.ResultVO.CourseResultVO;
import com.javaee.ResultVO.HomeworkVO;
import com.javaee.dataobject.*;
import com.javaee.dto.CheckDTO;
import com.javaee.dto.HomeworkDTO;
import com.javaee.service.CourseInfoService;
import com.javaee.service.HomeworkDetailService;
import com.javaee.service.HomeworkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    @Autowired
    private HomeworkInfoService service;
    @Autowired
    private HomeworkDetailService detailService;
    @Autowired
    private CourseInfoService courseInfoService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam("courseId") String courseId,
                             Map<String ,Object> map){
        List<HomeworkDTO> homeworkDTOList=service.findByCoueseIdList(courseId);
        CourseInfo courseInfo=courseInfoService.findOne(courseId);
        map.put("courseInfo",courseInfo);
        map.put("homeworkDTOList",homeworkDTOList);
        return new ModelAndView("/homework/list",map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "courseId",required = false) String courseId
            ,Map<String ,Object> map){
        if(courseId!=null){
            CourseInfo courseInfo=courseInfoService.findOne(courseId);
            map.put("courseInfo",courseInfo);
        }
        return new ModelAndView("/homework/index",map);
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "courseId",required = false) String courseId,
                             @RequestParam("homeworkIntro") String homeworkIntro,
                             Map<String ,Object> map){
        if(homeworkIntro==""){
            map.put("msg","作业信息填写不完全");
            map.put("url","/manager/homework/list?courseId="+courseId);
            return new ModelAndView("common/error",map);
        }
        HomeworkInfo homeworkInfo =new HomeworkInfo();
        homeworkInfo.setHomeworkIntro(homeworkIntro);
        homeworkInfo.setCourseId(courseId);
        service.create(homeworkInfo);
        map.put("msg","创建作业成功");
        map.put("url","/manager/homework/list?courseId="+courseId);
        return new ModelAndView("common/success",map);
    }
    @GetMapping("/detaillist")
    public ModelAndView detaillist(@RequestParam("homeworkId") Integer homeworkId,
                                   @RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "size",defaultValue = "2") Integer size,
                                   Map<String ,Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        HomeworkDTO homeworkDTO=service.findOne(homeworkId);
        Page<HomeworkDetail> homeworkDetailPage=detailService.findByHomeworkId(homeworkId,request);
        map.put("homeworkDTO",homeworkDTO);
        map.put("homeworkDetailPage",homeworkDetailPage);
        map.put("currentPage",page);
        return new ModelAndView("/homework/detaillist",map);
    }
    @PostMapping("/savegrade")
    @ResponseBody
    public HomeworkVO savegrade(@RequestParam("homeworkDetailid") Integer homeworkDetailid,
                                @RequestParam("homeworkGrade") Integer homeworkGrade){
        HomeworkDetail homeworkDetail=detailService.findOne(homeworkDetailid);
        if(homeworkGrade==null){
            HomeworkVO homeworkVO=new HomeworkVO();
            homeworkVO.setSuccess(false);
            homeworkVO.setMsg("数据不能为空");
            return homeworkVO;
        }
        homeworkDetail.setHomeworkGrade(homeworkGrade);
        detailService.save(homeworkDetail);
        HomeworkVO homeworkVO=new HomeworkVO();
        homeworkVO.setSuccess(true);
        homeworkVO.setMsg("保存成功");
        homeworkVO.setHomeworkGrade(homeworkGrade);
        return homeworkVO;

    }
}
