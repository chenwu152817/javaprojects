package com.javaee.repository;

import com.javaee.dataobject.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherInfoRepository extends JpaRepository<TeacherInfo,String > {
    List<TeacherInfo> findAll();
}
