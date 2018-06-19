package com.javaee.service.impl;

import com.javaee.dataobject.HomeworkInfo;
import com.javaee.dto.HomeworkDTO;
import com.javaee.service.HomeworkInfoService;
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
public class HomeworkInfoServiceImplTest {
    @Autowired
    private HomeworkInfoService service;
    @Test
    public void create() {
        HomeworkInfo homeworkInfo=new HomeworkInfo();
        homeworkInfo.setHomeworkIntro("第一次作业");
        homeworkInfo.setCourseId("123456");
        service.create(homeworkInfo);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findByCourseId() {
        List<HomeworkDTO> homeworkDTOList=service.findByCoueseIdList("123456");
        Assert.assertNotNull(homeworkDTOList);
    }
}