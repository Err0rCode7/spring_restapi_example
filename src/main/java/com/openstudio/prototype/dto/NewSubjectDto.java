package com.openstudio.prototype.dto;

import com.openstudio.prototype.domain.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewSubjectDto extends SuperDto {
    private String name;
    private String pdfRef;
    private String desc;
    private Long circle;

    public NewSubjectDto() {
    }

    public NewSubjectDto(String name, String pdfRef, String desc, Long circle) {
        this.name = name;
        this.pdfRef = pdfRef;
        this.desc = desc;
        this.circle = circle;
    }

    public NewSubjectDto(Subject subject) {
        this.name = subject.getName();
        this.pdfRef = subject.getPdfRef();
        this.desc = subject.getDescription();
        this.circle = subject.getCircle();
    }
}
