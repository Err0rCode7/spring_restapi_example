package com.openstudio.prototype.controller;

import com.openstudio.prototype.domain.Subject;
import com.openstudio.prototype.dto.*;
import com.openstudio.prototype.service.SubjectService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("subject")
    public ResponseEntity<SingleApiResponse<NewSubjectDto>> createSubject(
            @RequestBody NewSubjectDto newSubjectDto) {
        Optional<Subject> result = subjectService.createSubject(newSubjectDto);
        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    new SingleApiResponse<>(
                            "이미 서브젝트가 존재합니다.",
                            newSubjectDto
                    )
            );
        } else {
            return ResponseEntity.ok(
                    new SingleApiResponse<>(
                            "서브젝트가 만들어졌습니다.",
                            new NewSubjectDto(result.get())
                    )
            );
        }
    }

    @GetMapping("subject")
    public ResponseEntity<SingleApiResponse<SubjectDto>> getSubject(
            @RequestParam(value = "subjectName") String subjectName) {
        Optional<Subject> subject = subjectService.getSubjectByName(subjectName);
        if (subject.isPresent()) {
            return ResponseEntity.ok(
                    new SingleApiResponse<>(
                            "정상적으로 조회가 완료되었습니다.",
                            new SubjectDto(subject.get())
                    )
            );
        } else {
            return ResponseEntity.ok(
                    new SingleApiResponse<>(
                            "존재하지 않습니다.",
                            new SubjectDto()
                    )
            );
        }
    }

    @DeleteMapping("subject")
    public ResponseEntity<SingleApiResponse<SimpleSubjectDto>> deleteSubject(
            @RequestParam(value = "subjectName") String subjectName) {
        int result = subjectService.deleteSubject(subjectName);
        if (result > 0) {
            return ResponseEntity.ok(
                    new SingleApiResponse<>(
                            "정상적으로 삭제가 완료되었습니다.",
                            new SimpleSubjectDto(subjectName)
                    )
            );
        } else {
            return ResponseEntity.ok(
                    new SingleApiResponse<>(
                            "삭제할 서브젝트가 없습니다.",
                            new SimpleSubjectDto(subjectName)
                    )
            );
        }
    }

    @GetMapping("subject/a-week")
    public ResponseEntity<ListApiResponse<WeeklySubjectDto>> getWeeklySubjects() {
        Optional<List<WeeklySubjectDto>> weeklySubjectsByDateTime = subjectService
                .getWeeklySubjectsByDateTime(LocalDateTime.now());

        if (weeklySubjectsByDateTime.isPresent()) {
            return ResponseEntity.ok(
                    new ListApiResponse<>(
                            "정상적으로 서브젝트들을 반환했습니다.",
                            weeklySubjectsByDateTime.get()
                    ));
        } else {
            return ResponseEntity.ok(
                    new ListApiResponse<>(
                            "널 반환",
                            new ArrayList<WeeklySubjectDto>()
                    ));
        }
    }
}
