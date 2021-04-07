package com.openstudio.prototype.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommonResponse {
    private String timestamp;
    private String message;

    public CommonResponse(String message) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
    }
}
