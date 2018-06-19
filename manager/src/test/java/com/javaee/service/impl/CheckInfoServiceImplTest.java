package com.javaee.service.impl;

import com.javaee.dataobject.CheckInfo;
import com.javaee.dto.CheckDTO;
import com.javaee.service.CheckInfoService;
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
public class CheckInfoServiceImplTest {
    @Autowired
    private CheckInfoService checkInfoService;
    @Test
    public void create() {
        CheckInfo checkInfo=new CheckInfo();
        checkInfo.setCourseId("123456");
        checkInfo.setCheckIntro("第三次点名");
        checkInfoService.create(checkInfo);
    }

    @Test
    public void findOne() {
        CheckDTO checkDTO= checkInfoService.findOne(6);
        Assert.assertNotNull(checkDTO);
    }

    @Test
    public void findByCoueseIdList() {
        List<CheckDTO> checkDTOList=checkInfoService.findByCoueseIdList("123456");
        Assert.assertNotNull(checkDTOList);

    }
}