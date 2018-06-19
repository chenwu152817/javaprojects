package com.javaee.service;

import com.javaee.dataobject.CheckDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CheckDetailService {
    List<CheckDetail> findByCheckId(Integer checkId);
    CheckDetail save(CheckDetail checkDetail);
    CheckDetail findOne(Integer checkDetailId);
    Page<CheckDetail> findByCheckId(Integer checkId, Pageable pageable);
}
