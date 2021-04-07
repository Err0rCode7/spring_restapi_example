package com.openstudio.prototype.service;

import com.openstudio.prototype.domain.Member;
import com.openstudio.prototype.domain.Pool;
import com.openstudio.prototype.domain.Reservation;
import com.openstudio.prototype.domain.Subject;
import com.openstudio.prototype.dto.NewSubjectDto;
import com.openstudio.prototype.dto.WeeklySubjectDto;
import com.openstudio.prototype.repository.PoolRepository;
import com.openstudio.prototype.repository.ReservationRepository;
import com.openstudio.prototype.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final PoolRepository poolRepository;
    private final ReservationRepository reservationRepository;

    public SubjectService(SubjectRepository subjectRepository, PoolRepository poolRepository, ReservationRepository reservationRepository) {
        this.subjectRepository = subjectRepository;
        this.poolRepository = poolRepository;
        this.reservationRepository = reservationRepository;
    }

    public Optional<Subject> createSubject(NewSubjectDto newSubjectDto) {
        System.out.println("newSubjectDto = " + newSubjectDto.getName());
        Optional<Subject> subject = subjectRepository.findByName(newSubjectDto.getName());

        if (!subject.isPresent()) {
            Subject createdSubj = new Subject(newSubjectDto);
            Subject savedSubj = subjectRepository.save(createdSubj);
            return Optional.ofNullable(savedSubj);
        } else {
            return Optional.empty();
        }
    }

    public int deleteSubject(String subjectName) {
        return subjectRepository.deleteByName(subjectName);
    }

    public Optional<Subject> getSubjectByName(String subjectName) {
        return subjectRepository.findByName(subjectName);
    }

    public Optional<List<WeeklySubjectDto>> getWeeklySubjectsByDateTime(LocalDateTime dateTime) {
        Optional<List<Pool>> poolList = poolRepository.findByDateTime(dateTime);
        List<WeeklySubjectDto> result = new ArrayList<WeeklySubjectDto>();
        if (poolList.isPresent()) {
            poolList.get()
                .stream()
                .forEach((pool -> {
                    Long rsvCount = reservationRepository.countByPoolId(pool.getId());
                    Subject subject = pool.getSubject();
                    WeeklySubjectDto wsd = new WeeklySubjectDto(subject, rsvCount);
                    result.add(wsd);
                }));
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }
}
