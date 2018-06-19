package com.javaee.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class CheckDetail {
    @Id
    @GeneratedValue
    private Integer checkDetailid;
    private String studentId;
    private Integer checkId;
    private Integer checkStatus;

}
