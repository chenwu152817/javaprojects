package com.javaee.service;

import com.javaee.dataobject.HomeworkInfo;
import com.javaee.dto.HomeworkDTO;

import java.util.List;

public interface HomeworkInfoService {
    HomeworkDTO create(HomeworkInfo homeworkInfo);
    HomeworkDTO findOne(Integer homeworkId);
    List<HomeworkDTO> findByCoueseIdList(String courseId);
}
