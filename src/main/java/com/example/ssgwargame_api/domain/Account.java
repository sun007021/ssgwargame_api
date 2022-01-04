package com.example.ssgwargame_api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Account {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long idx;

    private String id;

    private String pw;

    private String introduce;

    private String nickname;

    @Embedded
    private Links links;

    private String ProfileImgLink;


    /** domainFields
     * Fields
     *- 1 : Pwnable
     * - 2 : Webhacking
     * - 3 : Reversing
     * - 4 : Misc
     * - 5 : ETC
     * ex> String : 100001 -> Pwnable, ETC에 관심있다.
     */
    private String domainFields;

   // @Embedded
    //private Score score;
}