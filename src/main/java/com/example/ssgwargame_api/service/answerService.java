package com.example.ssgwargame_api.service;

import com.example.ssgwargame_api.domain.Answer;
import com.example.ssgwargame_api.domain.Problems;
import com.example.ssgwargame_api.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class answerService {
    private final AnswerRepository answerRepository;

    public Answer findAnswer(Long id){ // id로 문제 조회
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()){
            return answer.get();
        }
        throw new EntityNotFoundException(
                "Cant find any answer under given ID");
    }
}
