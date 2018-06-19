package com.javaee.service.impl;

import com.javaee.dataobject.TeacherInfo;
import com.javaee.service.TeacherInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherInfoServiceImplTest {
    @Autowired
    private TeacherInfoService service;
    @Test
    public void findAll() {
        List<TeacherInfo> teacherInfoList=service.findAll();
        Assert.assertNotNull(teacherInfoList);
    }
}