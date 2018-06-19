package com.javaee.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TeacherInfo {
    @Id
    private String teacherId;
    private String teacherName;
    private String teacherPassword;

}
