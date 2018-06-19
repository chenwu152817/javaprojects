package com.javaee.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class CourseInfo {
    @Id
    private String courseId;
    private String courseName;
    private String teacherId;
    private String courseIntro;
    private Date createTime;
    private Date updateTime;
}
