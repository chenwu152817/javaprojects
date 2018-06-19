package com.javaee.handler;

import com.javaee.exception.ManagerException;
import com.javaee.exception.ManagerLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManagerExceptionHandler {
    @ExceptionHandler(value = ManagerException.class)
    @ResponseBody
    public ModelAndView handlerManagerException(ManagerException e) {
        Map<String ,Object> map =new HashMap<>();
        map.put("msg",e.getMessage());
        map.put("url","/manager/course/list");
        return new ModelAndView("common/error",map);
    }
    @ExceptionHandler(value = ManagerLoginException.class)
    public String handlerManagerLoginException(ManagerLoginException e){
        return "redirect:http://localhost:8080/manager/user/index";
    }
}
