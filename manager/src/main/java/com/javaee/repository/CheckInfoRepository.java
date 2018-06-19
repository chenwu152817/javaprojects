package com.javaee.repository;

import com.javaee.dataobject.CheckInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckInfoRepository extends JpaRepository<CheckInfo,Integer> {
    List<CheckInfo> findByCourseId(String courseId);
}
