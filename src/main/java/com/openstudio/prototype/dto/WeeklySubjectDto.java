package com.openstudio.prototype.dto;

import com.openstudio.prototype.domain.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeeklySubjectDto extends SubjectDto {
    private Long poolCount;

    public WeeklySubjectDto() {
        super();
    }

    public WeeklySubjectDto(String name, String pdfRef, String desc, Long circle, Long poolCount) {
        super(name, pdfRef, desc, circle);
        this.poolCount = poolCount;
    }

    public WeeklySubjectDto(Subject subject, Long poolCount) {
        super(subject);
        this.poolCount = poolCount;
    }
}
