package com.openstudio.prototype.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String intraId;
    private LocalDateTime createdAt;
    private String code;

    void changeCode(String code) {
        this.code = code;
    }

    public Member() {
    }

    public Member(String intraId, LocalDateTime createdAt, String code) {
        this.intraId = intraId;
        this.createdAt = createdAt;
        this.code = code;
    }

}
