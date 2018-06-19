package com.javaee.repository;

import com.javaee.dataobject.HomeworkDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class HomeworkDetailRepositoryTest {
    @Autowired
    private HomeworkDetailRepository repository;
    @Test
    public void save(){
        HomeworkDetail homeworkDetail=new HomeworkDetail();
        homeworkDetail.setStudentId("123");
        homeworkDetail.setHomeworkGrade(60);
        homeworkDetail.setHomeworkId(3);
        HomeworkDetail result =repository.save(homeworkDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void find(){
        PageRequest pageRequest=new PageRequest(0,1);
        List<HomeworkDetail> homeworkDetailList=repository.findByHomeworkId(11);
        Page<HomeworkDetail> homeworkDetailPage=new PageImpl<>(homeworkDetailList,pageRequest,3);
        Page<HomeworkDetail> homeworkDetailPage1=repository.findByHomeworkId(11,pageRequest);
        Page<HomeworkDetail> homeworkDetailPage2=new PageImpl<>(homeworkDetailList,pageRequest,homeworkDetailPage1.getTotalElements());
        Assert.assertNotNull(homeworkDetailPage);
    }

}