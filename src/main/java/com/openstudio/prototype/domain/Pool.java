package com.openstudio.prototype.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Pool {
    @Id
    @GeneratedValue
    @Column(name = "pool_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subject subject;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;

    @OneToMany(mappedBy = "pool", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    public Pool() {
    }

    public Pool(Subject subject, LocalDateTime createdAt, LocalDateTime closedAt) {
        this.subject = subject;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
    }
}
