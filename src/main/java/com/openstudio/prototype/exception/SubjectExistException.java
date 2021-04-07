package com.openstudio.prototype.exception;

import com.openstudio.prototype.exception.advice.ErrorCode;

public class SubjectExistException extends CustomException{

    private static final long serialVersionUID = -2116671122895194101L;

    public SubjectExistException() {
        super(ErrorCode.SUBJECT_EXIST);
    }
}
