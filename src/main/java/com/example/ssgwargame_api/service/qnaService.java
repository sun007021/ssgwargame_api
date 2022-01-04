package com.example.ssgwargame_api.service;

import com.example.ssgwargame_api.domain.Problems;
import com.example.ssgwargame_api.domain.QnA;
import com.example.ssgwargame_api.domain.request.QnASaveRequest;
import com.example.ssgwargame_api.repository.ProblemsRepository;
import com.example.ssgwargame_api.repository.QnARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class qnaService {

    public final QnARepository qnaRepository;
    public final ProblemsRepository problemsRepository;

    public QnA findQnA(Long id){ // id로 qna 질문 글 조회
        Optional<QnA> qna = qnaRepository.findById(id);
        if(qna.isPresent()){
            return qna.get();
        }
        throw new EntityNotFoundException(
                "Cant find any QnA under given ID");
    }

    public List<QnA> findQnA(){ // 전체 질문 조회
        return qnaRepository.findAll();
    }

    public QnA saveQnA(QnASaveRequest qna){ // 질문 추가
        Optional<Problems> problems = problemsRepository.findById(qna.getProblemsID());
        if (!problems.isPresent()) {
            throw new EntityNotFoundException(
                    "problem Not Found");
        }

        QnA qnaToSave =new QnA();
        BeanUtils.copyProperties(qna, qnaToSave);
        qnaToSave.setProblems(problems.get());

        return qnaRepository.save(qnaToSave);
    }

    public void deleteQnA(Long id){ //질문 삭제
        qnaRepository.deleteById(id);
    }

    public void updateQnA(Long id, QnA qna){
        Optional<QnA> optionalQnA = qnaRepository.findById(id);
        QnA q= optionalQnA.get();

        q.setTitle(qna.getTitle());
        q.setContent(qna.getContent());
        q.setAnswerNumber(qna.getAnswerNumber());
        q.setContent(qna.getContent());
        q.setAnswerNumber(qna.getAnswerNumber());
        q.setWriteTime(qna.getWriteTime());
        q.setUpvote(qna.getUpvote());
        q.setViewCount(qna.getViewCount());
        q.setProblems(qna.getProblems());
        //q.setAccount(qna.getAccount()); // account 개발 후 추가
    }
}
