package com.javaee.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class CheckInfo {
    @Id
    @GeneratedValue
    private Integer checkId;
    private String courseId;
    private String checkIntro;
    private Date createTime;
}
