package com.javaee.service;

import com.javaee.dataobject.CheckInfo;
import com.javaee.dto.CheckDTO;

import java.util.List;

public interface CheckInfoService  {
    CheckDTO create(CheckInfo checkInfo);
    CheckDTO findOne(Integer checkId);
    List<CheckDTO> findByCoueseIdList(String courseId);

}
