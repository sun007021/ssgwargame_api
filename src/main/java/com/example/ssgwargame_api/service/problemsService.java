package com.example.ssgwargame_api.service;

import com.example.ssgwargame_api.domain.Problems;
import com.example.ssgwargame_api.repository.ProblemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class problemsService {

    private final ProblemsRepository problemsRepository;


    public Problems findProblems(Long id){ // id로 문제 조회
        Optional<Problems> problems = problemsRepository.findById(id);
        if(problems.isPresent()){
            return problems.get();
        }
        throw new EntityNotFoundException(
                "Cant find any problem under given ID");
    }

    public List<Problems> findProblems(){ // 전체 문제 조회
        return problemsRepository.findAll();
    }

    public Problems saveProblems(Problems problems){ // 문제 추가
        problemsRepository.save(problems);
        return problems;
    }

    public void deleteProblems(Long id){ //문제 삭제
        problemsRepository.deleteById(id);
    }

    public void updateProblems(Long id, Problems problems){
        Optional<Problems> optionalProblems = problemsRepository.findById(id); //.orElseThrow(() -> new ResourceNotFoundException("Problems", "id", id));
        Problems p= optionalProblems.get();

        p.setTitle(problems.getTitle());
        p.setFlag(problems.getFlag());
        p.setFields(problems.getFields());
        p.setDescription(problems.getDescription());
        p.setScore(problems.getScore());
        p.setFilelink(problems.getFilelink());
        p.setFilename(problems.getFilename());

        problemsRepository.save(p);
    }
}
