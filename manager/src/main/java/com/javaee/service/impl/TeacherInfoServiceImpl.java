package com.javaee.service.impl;

import com.javaee.dataobject.TeacherInfo;
import com.javaee.repository.TeacherInfoRepository;
import com.javaee.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {
    @Autowired
    private TeacherInfoRepository repository;
    @Override
    public List<TeacherInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public TeacherInfo findOne(String teacherId) {
        return repository.findById(teacherId).orElse(null);
    }
}
