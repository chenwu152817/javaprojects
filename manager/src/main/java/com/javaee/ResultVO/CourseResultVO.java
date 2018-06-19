package com.javaee.ResultVO;

import lombok.Data;

@Data
public class CourseResultVO {
    private boolean success;
    private String msg;
    private Integer testGrade;
    private Integer courseGrade;
}
