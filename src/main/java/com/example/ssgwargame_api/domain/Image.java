package com.example.ssgwargame_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincreasement??
    @Column(name = "id")
    private Long id;

    @Column(name = "TargetTable")
    private Integer TargetTable;

    @Column(name = "TargetID")
    private Long TargetID;

    @Column(name = "link")
    private String link;

    @Column(name = "imgIndex")
    private Integer imgIndex;


}