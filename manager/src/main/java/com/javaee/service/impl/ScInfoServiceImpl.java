package com.javaee.service.impl;

import com.javaee.dataobject.ScInfo;
import com.javaee.repository.ScInfoRepository;
import com.javaee.service.ScInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScInfoServiceImpl implements ScInfoService {
    @Autowired
    private ScInfoRepository repository;
    @Override
    public ScInfo create(ScInfo scInfo) {
        return repository.save(scInfo);
    }

    @Override
    public ScInfo findOne(Integer scId) {

        return repository.findById(scId).orElse(null);
    }
    public ScInfo findOne(String studentId) {

        return repository.findByStudentId(studentId);
    }

    @Override
    public List<ScInfo> findByCourseId(String courseId) {
        return repository.findByCourseId(courseId);
    }

    @Override
    public ScInfo save(ScInfo scInfo) {
        return repository.save(scInfo);
    }
}
