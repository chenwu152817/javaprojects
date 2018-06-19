package com.javaee.form;

import lombok.Data;

@Data
public class StudentForm {
    private String studentId;
    private String studentName;
    private String courseId="";
}
