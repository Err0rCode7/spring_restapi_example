package com.openstudio.prototype.dto;

import com.openstudio.prototype.domain.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDto extends SuperDto{
    private String name;
    private String pdfRef;
    private String description;
    private Long circle;

    public SubjectDto() {
    }

    public SubjectDto(String name, String pdfRef, String desc, Long circle) {
        this.name = name;
        this.pdfRef = pdfRef;
        this.description = desc;
        this.circle = circle;
    }

    public SubjectDto(Subject subject) {
        this.name = subject.getName();
        this.pdfRef = subject.getPdfRef();
        this.description = subject.getDescription();
        this.circle = subject.getCircle();
    }
}
