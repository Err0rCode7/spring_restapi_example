package com.openstudio.prototype.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class TeamMember {
    @Id
    @GeneratedValue
    @Column(name = "team_member_id")
    private Long teamMemberId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    public TeamMember(Member member, Team team) {
        this.member = member;
        this.team = team;
    }
}
