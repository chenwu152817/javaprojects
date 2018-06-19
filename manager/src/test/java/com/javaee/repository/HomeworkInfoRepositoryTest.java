package com.javaee.repository;

import com.javaee.dataobject.HomeworkInfo;
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
public class HomeworkInfoRepositoryTest {
    @Autowired
    private HomeworkInfoRepository repository;
    @Test
    public void save(){
        HomeworkInfo homeworkInfo=new HomeworkInfo();
        homeworkInfo.setCourseId("123456");
        homeworkInfo.setHomeworkIntro("好好学习");
        HomeworkInfo result=repository.save(homeworkInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCourseId() {
        List<HomeworkInfo> homeworkInfoList=repository.findByCourseId("123456");
        Assert.assertEquals(1,homeworkInfoList.size());
    }
}