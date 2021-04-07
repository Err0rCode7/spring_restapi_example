package com.openstudio.prototype.dto;

public class SimpleSubjectDto extends SuperDto{
    private String name;

    public SimpleSubjectDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
