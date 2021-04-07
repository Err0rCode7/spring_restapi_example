package com.openstudio.prototype.repository;

import com.openstudio.prototype.domain.Pool;
import com.openstudio.prototype.domain.Subject;
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
class PoolRepositoryTest {

    private final PoolRepository poolRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public PoolRepositoryTest(PoolRepository poolRepository, SubjectRepository subjectRepository) {
        this.poolRepository = poolRepository;
        this.subjectRepository = subjectRepository;
    }

    @Test
    @DisplayName("날짜로 풀 검색하기")
    void getPoolByDate() {

        // Given
        // 현재 있는 모든 서브젝트에 대한 풀이 존재한다.
        List<Subject> subjects = subjectRepository.findAll();

        for (Subject subject : subjects) {
            LocalDateTime createdAt = LocalDateTime.of(2021, 4, 5, 0, 0, 0);
            LocalDateTime closedAt = LocalDateTime.of(2021, 4, 12, 0, 0, 0);
            Pool pool = new Pool(subject, createdAt, closedAt);
            poolRepository.save(pool);
        }

        // When
        // 오늘 날짜로 풀을 찾을 때

        Optional<List<Pool>> DateTime = poolRepository.findByDateTime(LocalDateTime.now());

        // Then
        // subjects 의 수 만큼의 풀이 나와야 한다.
        assertThat(DateTime.isPresent()).isTrue();
        if (DateTime.isPresent()) {
            assertThat(DateTime.get().size()).isEqualTo(subjects.size());
            for (Pool pool : DateTime.get()) {
                System.out.println("pool = " + pool.getSubject().getName());
            }
        }

    }
}