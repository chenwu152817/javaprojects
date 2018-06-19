package com.javaee.converter;

import com.javaee.dataobject.StudentInfo;
import com.javaee.form.StudentForm;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Student2Form {
    public static StudentForm convert(StudentInfo studentInfo){
        StudentForm studentForm=new StudentForm();
        BeanUtils.copyProperties(studentInfo,studentForm);
        return studentForm;
    }
    public static List<StudentForm> convert(List<StudentInfo> studentInfoList){
        return studentInfoList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
