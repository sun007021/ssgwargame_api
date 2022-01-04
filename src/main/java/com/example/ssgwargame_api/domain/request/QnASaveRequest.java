package com.example.ssgwargame_api.domain.request;

import com.example.ssgwargame_api.domain.Account;
import com.example.ssgwargame_api.domain.Problems;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class QnASaveRequest {
    private String title;
    private String content;
    private int answerNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime writeTime;
    private int upvote;
    private int viewCount;
    private Long problemsID;
    //private Long accountID;
}
