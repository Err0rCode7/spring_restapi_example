package com.openstudio.prototype.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subject subject;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;

    public Team(Subject subject, LocalDateTime createdAt, LocalDateTime closedAt) {
        this.subject = subject;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
    }
}
