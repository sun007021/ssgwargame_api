package com.example.ssgwargame_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long targetQuestion;

    @Column(columnDefinition = "varchar(120)")
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "int")
    private int upvote;

    @Column(columnDefinition = "datetime")
    private LocalDateTime writeTime;

    @ManyToOne
    @JoinColumn(name="QnA_id")
    private QnA qna;


}
