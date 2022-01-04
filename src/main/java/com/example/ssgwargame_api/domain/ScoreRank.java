package com.example.ssgwargame_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ScoreRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincreasement??
    @Column(name = "id")
    private Long id;

    @Column(name = "ScorePwnable")
    private Integer ScorePwnable;

    @Column(name = "ScoreWebhacking")
    private Integer ScoreWebhacking;

    @Column(name = "ScoreReversing")
    private Integer ScoreReversing;

    @Column(name = "ScoreMisc")
    private Integer ScoreMisc;

    @Column(name = "ScoreEtc")
    private Integer ScoreEtc;

    @Column(name = "ScoreTotal")
    private Integer ScoreTotal;

    @Column(name = "RankPwnable")
    private Integer RankPwnable;

    @Column(name = "RankWebhacking")
    private Integer RankWebhacking;

    @Column(name = "RankReversing")
    private Integer RankReversing;

    @Column(name = "RankMisc")
    private Integer RankMisc;

    @Column(name = "RankEtc")
    private Integer RankEtc;

    @Column(name = "RankTotal")
    private Integer RankTotal;

}