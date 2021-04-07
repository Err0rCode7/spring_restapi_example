package com.openstudio.prototype.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleApiResponse <T extends SuperDto> extends CommonResponse {

    private T result;

    public SingleApiResponse(String message, T object) {
        super(message);
        this.result = object;
    }
}
