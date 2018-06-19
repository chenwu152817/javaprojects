package com.javaee.controller;

import com.javaee.ResultVO.ResultVO;
import com.javaee.dataobject.TeacherInfo;
import com.javaee.service.TeacherInfoService;
import com.javaee.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TeacherInfoService service;
    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("login/login");
    }
    @PostMapping("/login")
    @ResponseBody
    public ResultVO login(@RequestParam("teacherId") String teacherId,
                          @RequestParam("teacherPassword") String teacherPassword,
                          Map<String ,Object> map,
                          HttpServletResponse response){
        //匹配教师
        TeacherInfo teacherInfo=service.findOne(teacherId);
        if(teacherId==null||teacherPassword==null){
            ResultVO resultVO=new ResultVO();
            resultVO.setMsg("账号密码不能为空");
            resultVO.setSuccess(false);
            return resultVO;
        }
        if(teacherInfo==null){
            ResultVO resultVO=new ResultVO();
            resultVO.setMsg("教师不存在");
            resultVO.setSuccess(false);
            return resultVO;
        }
        if(!teacherPassword.equals(teacherInfo.getTeacherPassword())){
            ResultVO resultVO=new ResultVO();
            resultVO.setMsg("密码输入错误");
            resultVO.setSuccess(false);
            return resultVO;
        }

        //设置token到cookie
        CookieUtil.set(response,"token",teacherId,7200);
        ResultVO resultVO=new ResultVO();

        resultVO.setSuccess(true);
        return resultVO;
    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               Map<String ,Object>map,
                               HttpServletResponse response) {
        //cookie里查询
        Cookie cookie = CookieUtil.get(request,"token");
        if (cookie != null) {
            //清除cookie
            CookieUtil.set(response, "token", null, 0);
        }
        map.put("msg","登出成功");
        map.put("url","/manager/user/index");
        return new ModelAndView("common/success",map);
    }
}
