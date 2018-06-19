package com.javaee.service.impl;

import com.javaee.dataobject.ScInfo;
import com.javaee.service.ScInfoService;
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
public class ScInfoServiceImplTest {
    @Autowired
    private ScInfoService scInfoService;
    @Test
    public void save() {
        ScInfo scInfo=new ScInfo("31501366","1234",0,0);
        ScInfo result=scInfoService.create(scInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void FindByCourseId(){
        List<ScInfo> scInfoList=new ArrayList<>();
        scInfoList=scInfoService.findByCourseId("123456");
        Assert.assertNotNull(scInfoList);
    }
}