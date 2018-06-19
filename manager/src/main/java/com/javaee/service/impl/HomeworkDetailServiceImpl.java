package com.javaee.service.impl;

import com.javaee.dataobject.HomeworkDetail;
import com.javaee.dto.HomeworkDTO;
import com.javaee.enums.ResultEnum;
import com.javaee.exception.ManagerException;
import com.javaee.repository.HomeworkDetailRepository;
import com.javaee.service.HomeworkDetailService;
import com.javaee.service.HomeworkInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class HomeworkDetailServiceImpl implements HomeworkDetailService {
    @Autowired
    private HomeworkDetailRepository repository;
    @Autowired
    private HomeworkInfoService homeworkInfoService;
    @Override
    public HomeworkDetail findOne(Integer homeworkDetailId) {
        return repository.findById(homeworkDetailId).orElse(null);
    }

    @Override
    public HomeworkDetail save(HomeworkDetail homeworkDetail) {
        return repository.save(homeworkDetail);
    }

    @Override
    public List<HomeworkDetail> findByHomeworkId(Integer homeworkId) {
        HomeworkDTO homeworkDTO=homeworkInfoService.findOne(homeworkId);
        if(homeworkDTO==null){
            throw new ManagerException(ResultEnum.HOMEWORK_NOT_EXIST);
        }
        return repository.findByHomeworkId(homeworkId);
    }

    @Override
    public Page<HomeworkDetail> findByHomeworkId(Integer homeworkId, Pageable pageable) {
        HomeworkDTO homeworkDTO=homeworkInfoService.findOne(homeworkId);
        if(homeworkDTO==null){
            throw new ManagerException(ResultEnum.HOMEWORK_NOT_EXIST);
        }
        return repository.findByHomeworkId(homeworkId,pageable);
    }
}
