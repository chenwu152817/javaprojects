package com.javaee.service.impl;

import com.javaee.dataobject.CourseInfo;
import com.javaee.enums.ResultEnum;
import com.javaee.exception.ManagerException;
import com.javaee.repository.CourseInfoRepository;
import com.javaee.service.CourseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    private CourseInfoRepository repository;
    @Override
    public CourseInfo create(CourseInfo courseInfo) {
        CourseInfo newCourse =new CourseInfo();
        newCourse=repository.findById(courseInfo.getCourseId()).orElse(null);
        if(newCourse!=null){
            log.error("【创建课程】课程已存在，Course={}",newCourse);
            throw new ManagerException(ResultEnum.CREATE_COURSE_ERROR);
        }
        return repository.save(courseInfo) ;
    }

    @Override
    public CourseInfo findOne(String courseId) {

        return repository.findById(courseId).orElse(null);
    }

    @Override
    public List<CourseInfo> findByTeacherId(String teacherId) {
        return repository.findByTeacherId(teacherId);
    }

    @Override
    public CourseInfo save(CourseInfo courseInfo) {
        return repository.save(courseInfo);
    }
}
