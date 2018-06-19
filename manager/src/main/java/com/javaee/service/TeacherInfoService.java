package com.javaee.service;

import com.javaee.dataobject.TeacherInfo;

import java.util.List;

public interface TeacherInfoService {
    List<TeacherInfo> findAll();
    TeacherInfo findOne(String teacherId);
}
