package com.javaee.dto;

import com.javaee.dataobject.CheckDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CheckDTO {
    private Integer checkId;
    private String courseId;
    private String checkIntro;
    private Date createTime;
    List<CheckDetail> checkDetailList;
}
