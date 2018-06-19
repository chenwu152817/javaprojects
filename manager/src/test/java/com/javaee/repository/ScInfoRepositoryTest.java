package com.javaee.repository;

import com.javaee.dataobject.ScInfo;
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
public class ScInfoRepositoryTest {
    @Autowired
    private ScInfoRepository repository;
    @Test
    public void save(){
        ScInfo scInfo =new ScInfo();
        scInfo.setStudentId("31501366");
        scInfo.setCourseId("1234");
        scInfo.setTestGrade(0);
        scInfo.setCourseGrade(0);
        ScInfo result= repository.save(scInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCourseId() {
        List<ScInfo> scInfo=repository.findByCourseId("1234");
        Assert.assertNotNull(scInfo);
    }
}