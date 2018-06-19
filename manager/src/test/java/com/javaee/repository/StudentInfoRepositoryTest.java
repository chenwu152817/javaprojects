package com.javaee.repository;

import com.javaee.dataobject.StudentInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentInfoRepositoryTest {
    @Autowired
    private StudentInfoRepository repository;
    @Test
    public void findByStudentId() {
        PageRequest pageRequest=new PageRequest(0,2);
        List<String> studentList=new ArrayList<>();
        studentList.add("31501367");
        studentList.add("31501368");
        studentList.add("31501369");
        studentList.add("31501370");
        Page<StudentInfo> studentInfoPage=repository.findByStudentId(studentList,pageRequest);
        Assert.assertNotNull(studentInfoPage);

    }
}