package com.javaee.service;

import com.javaee.dataobject.StudentInfo;
import com.javaee.form.StudentForm;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentInfoService {
    List<StudentInfo> findAll();
    StudentInfo findOne(String studentId);
    List<StudentInfo> findByStudentIdIn(List<String> studentList);
    Page<StudentForm> findByStudentId(String courseId,Pageable pageable);
}
