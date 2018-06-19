package com.javaee.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    CREATE_COURSE_ERROR(1,"课程编号已存在"),
    CREATE_CHECK_ERROP(2,"课程不存在"),
    CHECK_NOT_EXIST(3,"点名不存在"),
    HOMEWORK_NOT_EXIST(4,"作业不存在"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
