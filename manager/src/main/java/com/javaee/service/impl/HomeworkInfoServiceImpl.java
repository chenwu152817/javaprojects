package com.javaee.service.impl;

import com.javaee.converter.HomeworkInfo2HomeworkDTO;
import com.javaee.dataobject.CourseInfo;
import com.javaee.dataobject.HomeworkDetail;
import com.javaee.dataobject.HomeworkInfo;
import com.javaee.dto.HomeworkDTO;
import com.javaee.enums.ResultEnum;
import com.javaee.exception.ManagerException;
import com.javaee.repository.HomeworkDetailRepository;
import com.javaee.repository.HomeworkInfoRepository;
import com.javaee.service.CourseInfoService;
import com.javaee.service.HomeworkInfoService;
import com.javaee.service.ScInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HomeworkInfoServiceImpl implements HomeworkInfoService {
    @Autowired
    private HomeworkInfoRepository repository;
    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private ScInfoService scInfoService;
    @Autowired
    private HomeworkDetailRepository detailRepository;
    @Override
    public HomeworkDTO create(HomeworkInfo homeworkInfo) {
        HomeworkDTO homeworkDTO=new HomeworkDTO();
        CourseInfo courseInfo=courseInfoService.findOne(homeworkInfo.getCourseId());
        if(courseInfo==null){
            log.error("【创建点名】 课程不存在 CourseInfo={}",courseInfo);
            throw new ManagerException(ResultEnum.CREATE_CHECK_ERROP);
        }
        HomeworkInfo homeworkInfo1=repository.save(homeworkInfo);
        BeanUtils.copyProperties(homeworkInfo1,homeworkDTO);
        List<String> studentIdList= scInfoService.findByCourseId(homeworkInfo.getCourseId())
                .stream()
                .map(e->e.getStudentId())
                .collect(Collectors.toList());
        List<HomeworkDetail> homeworkDetailList=new ArrayList<>();
        for(String studentId:studentIdList){
            HomeworkDetail homeworkDetail =new HomeworkDetail();
            homeworkDetail.setHomeworkGrade(0);
            homeworkDetail.setStudentId(studentId);
            homeworkDetail.setHomeworkId(homeworkInfo.getHomeworkId());
            detailRepository.save(homeworkDetail);
            homeworkDetailList.add(homeworkDetail);
        }
        homeworkDTO.setHomeworkDetailList(homeworkDetailList);
        return homeworkDTO;
    }

    @Override
    public HomeworkDTO findOne(Integer homeworkId) {
        HomeworkDTO homeworkDTO=new HomeworkDTO();
        HomeworkInfo homeworkInfo=repository.findById(homeworkId).orElse(null);
        if(homeworkInfo==null){
            log.info("【查询作业】作业不存在");
            throw new ManagerException(ResultEnum.HOMEWORK_NOT_EXIST);
        }
        BeanUtils.copyProperties(homeworkInfo,homeworkDTO);
        List<HomeworkDetail> homeworkDetailList=detailRepository.findByHomeworkId(homeworkId);
        homeworkDTO.setHomeworkDetailList(homeworkDetailList);
        return homeworkDTO;
    }

    @Override
    public List<HomeworkDTO> findByCoueseIdList(String courseId) {
        CourseInfo courseInfo=courseInfoService.findOne(courseId);
        if(courseInfo==null){
            log.error("【创建点名】 点名课程不存在 CourseInfo={}",courseInfo);
            throw new ManagerException(ResultEnum.CREATE_CHECK_ERROP);
        }
        List<HomeworkInfo> homeworkInfoList=repository.findByCourseId(courseId);
        List<HomeworkDTO> homeworkDTOList=HomeworkInfo2HomeworkDTO.convert(homeworkInfoList);
        for(HomeworkDTO homeworkDTO:homeworkDTOList){
            List<HomeworkDetail> homeworkDetailList=detailRepository.findByHomeworkId(homeworkDTO.getHomeworkId());
            homeworkDTO.setHomeworkDetailList(homeworkDetailList);
        }
        return homeworkDTOList;
    }
}
