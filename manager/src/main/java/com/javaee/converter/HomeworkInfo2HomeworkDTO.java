package com.javaee.converter;

import com.javaee.dataobject.HomeworkInfo;
import com.javaee.dto.HomeworkDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomeworkInfo2HomeworkDTO {
    public static HomeworkDTO convert(HomeworkInfo homeworkInfo){
        HomeworkDTO homeworkDTO=new HomeworkDTO();
        BeanUtils.copyProperties(homeworkInfo,homeworkDTO);
        return homeworkDTO;
    }
    public static List<HomeworkDTO> convert(List<HomeworkInfo> homeworkInfoList){
        return homeworkInfoList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
