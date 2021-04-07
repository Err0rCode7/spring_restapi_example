package com.openstudio.prototype.service;

import com.openstudio.prototype.domain.Member;
import com.openstudio.prototype.domain.Pool;
import com.openstudio.prototype.domain.Reservation;
import com.openstudio.prototype.domain.Subject;
import com.openstudio.prototype.dto.WeeklySubjectDto;
import com.openstudio.prototype.repository.PoolRepository;
import com.openstudio.prototype.repository.ReservationRepository;
import com.openstudio.prototype.repository.SubjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SubjectServiceTest {

    PoolRepository poolRepository;
    ReservationRepository reservationRepository;
    SubjectRepository subjectRepository;
    SubjectService subjectService;

    @Autowired
    public SubjectServiceTest(PoolRepository poolRepository, ReservationRepository reservationRepository, SubjectRepository subjectRepository, SubjectService subjectService) {
        this.poolRepository = poolRepository;
        this.reservationRepository = reservationRepository;
        this.subjectRepository = subjectRepository;
        this.subjectService = subjectService;
    }

    @Test
    @DisplayName("WeeklySubjectDto pass case 테스트")
    void 위클리_서브젝트_테스트_pass() {
        // Given
        // 서브젝트가 6개 존재 -> 풀이 6개 존재
        // 이번주 libft 대한 예약이 2개만 존재할 때
       /* List<Subject> subjects = subjectRepository.findAll();

        for (Subject subject : subjects) {
            LocalDateTime createdAt = LocalDateTime.of(2021, 4, 5, 0, 0, 0);
            LocalDateTime closedAt = LocalDateTime.of(2021, 4, 12, 0, 0, 0);
            Pool pool = new Pool(subject, createdAt, closedAt);
            poolRepository.save(pool);
            if (subject.getName().equals("libft")) {
                Member member1 = new Member("seujeon", LocalDateTime.now(), "testCode0");
                Member member2 = new Member("testMember", LocalDateTime.now(), "testCode1");
                Reservation reservation1 = new Reservation(member1, pool);
                Reservation reservation2 = new Reservation(member2, pool);
                reservationRepository.save(reservation1);
                reservationRepository.save(reservation2);
            }
        }*/

        // When
        // WeeklySubjectDto를 구했을 때
        List<WeeklySubjectDto> weeklySubjectDtos = subjectService.getWeeklySubjectsByDateTime(LocalDateTime.now());

        // Then
        // libft 의 pool count가 2이고 나머지 count는 0이여야함.
            weeklySubjectDtos
                .stream()
                .forEach((weeklySubjectDto -> {
                    System.out.println(
                            "Name = " + weeklySubjectDto.getName()
                            + "PoolCount" + weeklySubjectDto.getPoolCount());
                    if (weeklySubjectDto.getName().equals("libft")) {
                        assertThat(weeklySubjectDto.getPoolCount()).isEqualTo(2);
                    } else {
                        assertThat(weeklySubjectDto.getPoolCount()).isEqualTo(0);
                    }
                }));

    }
}