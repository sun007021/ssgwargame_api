package com.example.ssgwargame_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long targetProblem;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "int")
    private int writerId;

    @Column(columnDefinition = "datetime")
    private LocalDateTime writeTime;
}
