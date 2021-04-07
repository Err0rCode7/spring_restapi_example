package com.openstudio.prototype.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intra_id")
    @JsonIgnore
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pool_id")
    @JsonIgnore
    private Pool pool;

    public Reservation(Member member, Pool pool) {
        this.member = member;
        this.pool = pool;
    }
}
