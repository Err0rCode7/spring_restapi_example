package com.openstudio.prototype.exception.advice;

import lombok.Getter;

@Getter
public enum ErrorCode {
    MEMBER_EXIST(409, "M01", "사용자가 이미 존재합니다."),
    MEMBER_NOT_EXIST(404, "M02", "사용자가 존재하지 않습니다."),
    SUBJECT_EXIST(405, "M03", "서브젝트가 이미 존재합니다."),
    SUBJECT_NOT_EXIST(406, "M04", "서브젝트가 존재하지 않습니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
