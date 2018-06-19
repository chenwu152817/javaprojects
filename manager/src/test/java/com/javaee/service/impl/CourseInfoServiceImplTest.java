package com.javaee.service.impl;

import com.javaee.dataobject.CourseInfo;
import com.javaee.service.CourseInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseInfoServiceImplTest {
    @Autowired
    private CourseInfoService courseInfoService;
    @Test
    public void create() {
        CourseInfo courseInfo=new CourseInfo();
        courseInfo.setCourseId("1234567");
        courseInfo.setTeacherId("45678");
        courseInfo.setCourseName("JAVA高阶");
        courseInfo.setCourseIntro("很无聊的课");
        CourseInfo result=courseInfoService.create(courseInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findByTeacherId() {
    }

    @Test
    public void save() {
    }
}