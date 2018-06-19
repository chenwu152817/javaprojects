package com.javaee.repository;

import com.javaee.dataobject.CheckInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CheckInfoRepositoryTest {
    @Autowired
    private CheckInfoRepository repository;
    @Test
    public void save(){
        CheckInfo checkInfo=new CheckInfo();
        checkInfo.setCheckIntro("第一次点名");
        checkInfo.setCourseId("123456");
        CheckInfo result=repository.save(checkInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCourseId() {
    }
}