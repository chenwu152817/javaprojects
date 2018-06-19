package com.javaee.form;

import lombok.Data;

@Data
public class ScForm {
    private Integer scId;
    private String studentId;
    private String studentName;
    private String courseId;
    private Integer testGrade=0;
    private Integer courseGrade=0;
}
