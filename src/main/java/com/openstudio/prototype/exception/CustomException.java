package com.openstudio.prototype.exception;

import com.openstudio.prototype.exception.advice.ErrorCode;
import lombok.Getter;

public class CustomException extends RuntimeException{

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
