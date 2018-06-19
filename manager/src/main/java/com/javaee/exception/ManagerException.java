package com.javaee.exception;

import com.javaee.enums.ResultEnum;
import lombok.Getter;

@Getter
public class ManagerException extends RuntimeException {
    private Integer code;
    public ManagerException(Integer code,String message) {
        super(message);
        this.code=code;
    }
    public ManagerException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
