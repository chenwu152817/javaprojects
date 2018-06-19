package com.javaee.repository;

import com.javaee.dataobject.HomeworkDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkDetailRepository extends JpaRepository<HomeworkDetail,Integer> {
    List<HomeworkDetail> findByHomeworkId(Integer homeworkId);
    Page<HomeworkDetail> findByHomeworkId(Integer homeworkId, Pageable pageable);
}
