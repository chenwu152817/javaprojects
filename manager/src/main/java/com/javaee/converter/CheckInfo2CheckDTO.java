package com.javaee.converter;

import com.javaee.dataobject.CheckInfo;
import com.javaee.dto.CheckDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CheckInfo2CheckDTO {
    public static CheckDTO convert(CheckInfo checkInfo){
        CheckDTO checkDTO=new CheckDTO();
        BeanUtils.copyProperties(checkInfo,checkDTO);
        return checkDTO;
    }
    public static List<CheckDTO> convert(List<CheckInfo> checkInfoList){
        return checkInfoList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
