package com.javaee.service.impl;

import com.javaee.converter.Student2Form;
import com.javaee.dataobject.ScInfo;
import com.javaee.dataobject.StudentInfo;
import com.javaee.form.StudentForm;
import com.javaee.repository.ScInfoRepository;
import com.javaee.repository.StudentInfoRepository;
import com.javaee.service.ScInfoService;
import com.javaee.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoRepository repository;
    @Autowired
    private ScInfoRepository scInfoRepository;
    @Autowired
    private ScInfoService scInfoService;
    @Autowired
    private StudentInfoService studentInfoService;
    @Override
    public List<StudentInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentInfo findOne(String studentId) {
        return repository.findById(studentId).orElse(null);
    }
    public List<StudentInfo> findByStudentIdIn(List<String> studentList){
        return repository.findByStudentIdIn(studentList);
    };
    public Page<StudentForm> findByStudentId(String courseId,Pageable pageable){
        Page<ScInfo> scInfoPage=scInfoRepository.findByCourseId(courseId,pageable);
        List<ScInfo> scInfoList=scInfoService.findByCourseId(courseId);
        List<String> studentList =
                scInfoList.stream()
                        .map(e->e.getStudentId())
                        .collect(Collectors.toList());
        List<StudentInfo> studentInfoList=studentInfoService
                .findByStudentIdIn(studentList);
        List<StudentForm> studentFormList=Student2Form.convert(studentInfoList);
         Page<StudentForm> studentFormPage= new PageImpl<StudentForm>(studentFormList,pageable,scInfoPage.getTotalElements());
        return studentFormPage;
    };
}
