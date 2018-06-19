package com.javaee.service;

import com.javaee.dataobject.CourseInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseInfoService {
    CourseInfo create(CourseInfo courseInfo);
    CourseInfo findOne(String courseId);
    List<CourseInfo> findByTeacherId(String teacherId);
    CourseInfo save(CourseInfo courseInfo);
}
