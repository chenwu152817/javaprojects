package com.javaee.repository;

import com.javaee.dataobject.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseInfoRepository extends JpaRepository<CourseInfo,String> {
    List<CourseInfo> findByTeacherId(String teacherId);
}
