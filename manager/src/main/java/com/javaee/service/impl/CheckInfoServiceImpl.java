package com.javaee.service.impl;

import com.javaee.converter.CheckInfo2CheckDTO;
import com.javaee.dataobject.CheckDetail;
import com.javaee.dataobject.CheckInfo;
import com.javaee.dataobject.CourseInfo;
import com.javaee.dataobject.StudentInfo;
import com.javaee.dto.CheckDTO;
import com.javaee.enums.CheckEnum;
import com.javaee.enums.ResultEnum;
import com.javaee.exception.ManagerException;
import com.javaee.repository.CheckDetailRepository;
import com.javaee.repository.CheckInfoRepository;
import com.javaee.service.CheckInfoService;
import com.javaee.service.CourseInfoService;
import com.javaee.service.ScInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CheckInfoServiceImpl implements CheckInfoService {
    @Autowired
    private CheckInfoRepository repository;
    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private ScInfoService scInfoService;
    @Autowired
    private CheckDetailRepository detailRepository;
    @Override
    @Transactional
    public CheckDTO create(CheckInfo checkInfo) {
        CheckDTO checkDTO =new CheckDTO();
        /**查询课程*/
        CourseInfo courseInfo=courseInfoService.findOne(checkInfo.getCourseId());
        if(courseInfo==null){
            log.error("【创建点名】 点名课程不存在 CourseInfo={}",courseInfo);
            throw new ManagerException(ResultEnum.CREATE_CHECK_ERROP);
        }
        /**保存点名信息*/
        CheckInfo checkInfo1=repository.save(checkInfo);
        BeanUtils.copyProperties(checkInfo1,checkDTO);
        /**保存点名详情*/
        List<String> studentIdList= scInfoService.findByCourseId(checkInfo.getCourseId())
                .stream()
                .map(e->e.getStudentId())
                .collect(Collectors.toList());
        List<CheckDetail> checkDetailList=new ArrayList<>();
        for(String studentId:studentIdList){
            CheckDetail checkDetail =new CheckDetail();
            checkDetail.setCheckId(checkInfo1.getCheckId());
            checkDetail.setCheckStatus(CheckEnum.PRESENT.getCode());
            checkDetail.setStudentId(studentId);
            checkDetailList.add(checkDetail);
            detailRepository.save(checkDetail);
        }
        checkDTO.setCheckDetailList(checkDetailList);
        return checkDTO;
    }

    @Override
    public CheckDTO findOne(Integer checkId) {
        CheckDTO checkDTO =new CheckDTO();
        CheckInfo checkInfo=repository.findById(checkId).orElse(null);
        if(checkInfo==null){
            log.error("【查询点名】 点名不存在 checkInfo={}",checkInfo);
            throw new ManagerException(ResultEnum.CHECK_NOT_EXIST);
        }
        BeanUtils.copyProperties(checkInfo,checkDTO);
        List<CheckDetail> checkDetailList=detailRepository.findByCheckId(checkId);
        checkDTO.setCheckDetailList(checkDetailList);

        return checkDTO;
    }

    @Override
    public List<CheckDTO> findByCoueseIdList(String courseId) {
        CourseInfo courseInfo=courseInfoService.findOne(courseId);
        if(courseInfo==null){
            log.error("【创建点名】 点名课程不存在 CourseInfo={}",courseInfo);
            throw new ManagerException(ResultEnum.CREATE_CHECK_ERROP);
        }
        List<CheckInfo> checkInfoList=repository.findByCourseId(courseId);
        List<CheckDTO> checkDTOList=CheckInfo2CheckDTO.convert(checkInfoList);
        for(CheckDTO checkDTO:checkDTOList){
            List<CheckDetail> checkDetailList=detailRepository.findByCheckId(checkDTO.getCheckId());
            checkDTO.setCheckDetailList(checkDetailList);


         }
        return checkDTOList;
    }
}
