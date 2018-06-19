package com.javaee.service.impl;

import com.javaee.dataobject.CheckDetail;
import com.javaee.dataobject.CheckInfo;
import com.javaee.dto.CheckDTO;
import com.javaee.enums.ResultEnum;
import com.javaee.exception.ManagerException;
import com.javaee.repository.CheckDetailRepository;
import com.javaee.service.CheckDetailService;
import com.javaee.service.CheckInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

@Service
@Slf4j
public class CheckDetailServiceImpl implements CheckDetailService {
    @Autowired
    private CheckInfoService checkInfoService;
    @Autowired
    private CheckDetailRepository repository;
    @Override
    public List<CheckDetail> findByCheckId(Integer checkId) {
        CheckDTO checkDTO=checkInfoService.findOne(checkId);
        if(checkDTO==null){
            log.info("【查询点名详细】该次点名不存在");
            throw new ManagerException(ResultEnum.CHECK_NOT_EXIST);
        }
        return repository.findByCheckId(checkId);
    }

    @Override
    public CheckDetail save(CheckDetail checkDetail) {
        return repository.save(checkDetail);
    }

    @Override
    public CheckDetail findOne(Integer checkDetailId) {
        return repository.findById(checkDetailId).orElse(null);
    }

    @Override
    public Page<CheckDetail> findByCheckId(Integer checkId, Pageable pageable) {
        CheckDTO checkDTO=checkInfoService.findOne(checkId);
        if(checkDTO==null){
            log.info("【查询点名详细】该次点名不存在");
            throw new ManagerException(ResultEnum.CHECK_NOT_EXIST);
        }
        return repository.findByCheckId(checkId,pageable);
    }
}
