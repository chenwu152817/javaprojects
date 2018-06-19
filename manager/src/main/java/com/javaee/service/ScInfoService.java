package com.javaee.service;

import com.javaee.dataobject.ScInfo;
import com.javaee.dataobject.StudentInfo;

import java.util.List;

public interface ScInfoService {
    /**创建选课信息*/
    ScInfo create(ScInfo scInfo);
    /**根据选课Id查找选课信息*/
    ScInfo findOne(Integer scId);
    ScInfo findOne(String  studentId);
    /**根据课程ID查询选课信息*/
    List<ScInfo> findByCourseId(String courseId);
    ScInfo save(ScInfo scInfo);
}
