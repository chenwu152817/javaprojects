package com.javaee.repository;

import com.javaee.dataobject.CheckDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckDetailRepository extends JpaRepository<CheckDetail,Integer> {
    List<CheckDetail> findByCheckId(Integer checkId);
    Page<CheckDetail> findByCheckId(Integer checkId, Pageable pageable);
}
