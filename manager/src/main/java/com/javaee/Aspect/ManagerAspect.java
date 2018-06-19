package com.javaee.Aspect;

import com.javaee.dataobject.TeacherInfo;
import com.javaee.exception.ManagerLoginException;
import com.javaee.service.TeacherInfoService;
import com.javaee.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
@Slf4j
public class ManagerAspect {
    @Autowired
    TeacherInfoService service;
    @Pointcut("execution(public * com.javaee.controller.*.*(..))" +
            "&& !execution(public * com.javaee.controller.UserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie
        Cookie cookie = CookieUtil.get(request, "token");

        if (cookie == null) {
            log.warn("【登陆校验】Cookie中查不到token");
            throw new ManagerLoginException();
        }
        String teacherId=cookie.getValue();
        TeacherInfo teacherInfo=service.findOne(teacherId);
        if(teacherInfo==null){
            log.warn("【登陆校验】Cookie中查不到正确的token");
            throw new ManagerLoginException();
        }
    }
}