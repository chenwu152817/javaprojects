package com.javaee.repository;

import com.javaee.dataobject.ScInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScInfoRepository extends JpaRepository<ScInfo,Integer> {
    List<ScInfo> findByCourseId(String courseId);
    ScInfo findByStudentId(String studentId);
    Page<ScInfo> findByCourseId(String courseId, Pageable pageable);
}
