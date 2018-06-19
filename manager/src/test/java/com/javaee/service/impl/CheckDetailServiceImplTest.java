package com.javaee.service.impl;

import com.javaee.dataobject.CheckDetail;
import com.javaee.service.CheckDetailService;
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
public class CheckDetailServiceImplTest {
    @Autowired
    private CheckDetailService service;
    @Test
    public void findByCheckId() {
        List<CheckDetail> checkDetailList=service.findByCheckId(6);
        Assert.assertEquals(3,checkDetailList.size());
    }

    @Test
    public void save() {
    }
}