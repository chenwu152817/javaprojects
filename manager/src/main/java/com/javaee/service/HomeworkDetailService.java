package com.javaee.service;

import com.javaee.dataobject.HomeworkDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HomeworkDetailService {
    HomeworkDetail findOne(Integer homeworkDetailId);
    HomeworkDetail save(HomeworkDetail homeworkDetail);
    List<HomeworkDetail> findByHomeworkId(Integer homeworkId);
    Page<HomeworkDetail> findByHomeworkId(Integer homeworkId, Pageable pageable);
}
