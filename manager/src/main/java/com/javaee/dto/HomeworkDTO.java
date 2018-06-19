package com.javaee.dto;

import com.javaee.dataobject.HomeworkDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HomeworkDTO {
    private Integer homeworkId;
    private String courseId;
    private String homeworkIntro;
    private Date createTime;
    List<HomeworkDetail> homeworkDetailList;
}
