package com.openstudio.prototype.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListApiResponse<T extends SuperDto> extends CommonResponse{
    private List<T> result;

    public ListApiResponse(String message, List<T> result) {
        super(message);
        this.result = result;
    }
}
