package com.javaee.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class StudentInfo {
    @Id
    private String studentId;
    private String studentName;
}
