package com.javaee.repository;

import com.javaee.dataobject.HomeworkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkInfoRepository extends JpaRepository<HomeworkInfo,Integer> {
    List<HomeworkInfo> findByCourseId(String courseId);
}
