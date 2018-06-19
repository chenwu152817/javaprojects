package com.javaee.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ScInfo {
    @Id
    @GeneratedValue
    private Integer scId;
    private String studentId;
    private String courseId;
    private Integer testGrade=0;
    private Integer courseGrade=0;
    public ScInfo(){}
    public ScInfo(String studentId,String courseId,Integer testGrade,Integer courseGrade){
        this.studentId=studentId;
        this.courseId=courseId;
        this.courseGrade=courseGrade;
        this.testGrade=testGrade;
    }
}
