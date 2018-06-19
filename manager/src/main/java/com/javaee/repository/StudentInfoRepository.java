package com.javaee.repository;

import com.javaee.dataobject.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,String> {
    List<StudentInfo> findAll();
    List<StudentInfo> findByStudentIdIn(List<String> studentList);
    Page<StudentInfo> findByStudentId(List<String> studentList, Pageable pageable);
}
