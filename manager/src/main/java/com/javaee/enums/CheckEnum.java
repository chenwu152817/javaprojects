package com.javaee.enums;

import lombok.Getter;

@Getter
public enum CheckEnum {
    PRESENT(0,"到课"),
    ABSENT(1,"缺课"),
    ;
    private Integer code;
    private String message;

    CheckEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
