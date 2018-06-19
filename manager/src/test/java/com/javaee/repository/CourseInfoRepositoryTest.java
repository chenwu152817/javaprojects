package com.javaee.repository;

import com.javaee.dataobject.CourseInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseInfoRepositoryTest {
    @Autowired
    private CourseInfoRepository repository;
    @Test
    public void save(){
        CourseInfo courseInfo =new CourseInfo();
        courseInfo.setCourseId("1234");
        courseInfo.setCourseName("数据库开发与设计");
        courseInfo.setCourseIntro("很有趣的课");
        courseInfo.setTeacherId("C13012");
        CourseInfo result=repository.save(courseInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByTeacherId() {
        List<CourseInfo> courseInfoList= new ArrayList<>();
        courseInfoList=repository.findByTeacherId("C13012");
        Assert.assertEquals(2,courseInfoList.size());
    }
}