package com.javaee.controller;

import com.javaee.dataobject.CheckDetail;
import com.javaee.dataobject.CheckInfo;
import com.javaee.dataobject.CourseInfo;
import com.javaee.dto.CheckDTO;
import com.javaee.service.CheckDetailService;
import com.javaee.service.CheckInfoService;
import com.javaee.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/check")
public class CheckController {
    @Autowired
    CheckInfoService service;
    @Autowired
    CheckDetailService checkDetailService;
    @Autowired
    CourseInfoService courseInfoService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam("courseId") String courseId,
                             Map<String ,Object> map){
        List<CheckDTO> checkDTOList=service.findByCoueseIdList(courseId);
        CourseInfo courseInfo=courseInfoService.findOne(courseId);
        map.put("courseInfo",courseInfo);
        map.put("checkDTOList",checkDTOList);
        return new ModelAndView("/check/list",map);


    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "courseId",required = false) String courseId
            ,Map<String ,Object> map){
        if(courseId!=null){
            CourseInfo courseInfo=courseInfoService.findOne(courseId);
            map.put("courseInfo",courseInfo);
        }
        return new ModelAndView("/check/index",map);
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "courseId",required = false) String courseId,
                             @RequestParam("checkIntro") String checkIntro,
                             Map<String ,Object> map){
        if(checkIntro==""){
            map.put("msg","点名信息填写不完全");
            map.put("url","/manager/check/list?courseId="+courseId);
            return new ModelAndView("common/error",map);
        }
        CheckInfo checkInfo=new CheckInfo();
        checkInfo.setCheckIntro(checkIntro);
        checkInfo.setCourseId(courseId);
        service.create(checkInfo);
        map.put("msg","创建点名成功");
        map.put("url","/manager/check/list?courseId="+courseId);
        return new ModelAndView("common/success",map);
    }
    @GetMapping("/detaillist")
    public ModelAndView detaillist(@RequestParam("checkId") Integer checkId,
                                   @RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "size",defaultValue = "2") Integer size,
                                    Map<String ,Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        CheckDTO checkDTO=service.findOne(checkId);
        Page<CheckDetail> checkDetailPage=checkDetailService.findByCheckId(checkId,request);
        map.put("checkDTO",checkDTO);
        map.put("checkDetailPage",checkDetailPage);
        map.put("currentPage",page);
        return new ModelAndView("/check/detaillist",map);
    }
    @GetMapping("/absent")
    public ModelAndView absent(@RequestParam("checkId") Integer checkId,
                               @RequestParam("checkDetailid") Integer checkDetailid,
                               @RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "size",defaultValue = "2") Integer size,
                               Map<String ,Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        CheckDetail checkDetail=checkDetailService.findOne(checkDetailid);
        checkDetail.setCheckStatus(1);
        checkDetailService.save(checkDetail);
        CheckDTO checkDTO=service.findOne(checkId);
        Page<CheckDetail> checkDetailPage=checkDetailService.findByCheckId(checkId,request);
        map.put("checkDTO",checkDTO);
        map.put("checkDetailPage",checkDetailPage);
        map.put("currentPage",page);
        return new ModelAndView("/check/detaillist",map);


    }
    @GetMapping("/present")
    public ModelAndView present(@RequestParam("checkId") Integer checkId,
                               @RequestParam("checkDetailid") Integer checkDetailid,
                               @RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "size",defaultValue = "2") Integer size,
                               Map<String ,Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        CheckDetail checkDetail=checkDetailService.findOne(checkDetailid);
        checkDetail.setCheckStatus(0);
        checkDetailService.save(checkDetail);
        CheckDTO checkDTO=service.findOne(checkId);
        Page<CheckDetail> checkDetailPage=checkDetailService.findByCheckId(checkId,request);
        map.put("checkDTO",checkDTO);
        map.put("checkDetailPage",checkDetailPage);
        map.put("currentPage",page);
        return new ModelAndView("/check/detaillist",map);


    }
}
