package com.javaee.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class HomeworkInfo {
    @Id
    @GeneratedValue
    private Integer homeworkId;
    private String courseId;
    private String homeworkIntro;
    private Date createTime;

}
