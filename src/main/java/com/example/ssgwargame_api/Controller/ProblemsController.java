package com.example.ssgwargame_api.Controller;

import com.example.ssgwargame_api.domain.Problems;
import com.example.ssgwargame_api.domain.QnA;
import com.example.ssgwargame_api.domain.request.QnASaveRequest;
import com.example.ssgwargame_api.repository.ProblemsRepository;
import com.example.ssgwargame_api.repository.QnARepository;
import com.example.ssgwargame_api.service.problemsService;
import com.example.ssgwargame_api.service.qnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // json 형태로 결과값 반환 ResponseBody 사용할 필요 없음
@RequiredArgsConstructor // final 객체 constructor injection 해준다. Autowired 역할
@RequestMapping("/v1")
public class ProblemsController {
    private final ProblemsRepository problemsRepository;
    private final problemsService problemsService;
    private final QnARepository qnaRepository;
    private final qnaService qnaService;

    /**
     * 문제조회
     * @return
     */
    @GetMapping("problems")
    public ResponseEntity findProblmes(@RequestParam(required = false) Long id){
        if(id == null){
            return ResponseEntity.ok(problemsService.findProblems());
        }
        else{
            return ResponseEntity.ok(problemsService.findProblems(id));
        }


    }

    /*
    @PostMapping("problems")
    public Problems saveProblems(){
        final Problems problem = Problems.builder()
                .title("t1")
                .flag("t1flag")
                .fields(1)
                .description("설명")
                .score(100)
                .filelink("url")
                .filename("t1name")
                .build();
        return problemsRepository.save(problem);

    }
     */
    /**
     * 문제등록
     */
    @PostMapping("problems") // title flag fields description score filelink filename
    public ResponseEntity<Problems> saveProblems(@RequestBody Problems problems){
        return new ResponseEntity<Problems>(problemsService.saveProblems(problems), HttpStatus.OK);

    }

    /**
     * 문제 삭제
     * @param id
     * @return
     */
    @DeleteMapping("problems")
    public ResponseEntity deleteProblems(@RequestParam(required = true) Long id){
        problemsService.deleteProblems(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 문제 수정
     * @param id
     * @param problems
     * @return
     */
    @PutMapping("problems")
    public ResponseEntity<Problems> updateProblems(@RequestParam Long id, @RequestBody Problems problems){
        problemsService.updateProblems(id, problems);
        return new ResponseEntity<Problems>(problems, HttpStatus.OK);
    }
    //-----------------------------------------------

    /**
     * 질문 조회
     * @param id
     * @return
     */
    @GetMapping("qna")
    public ResponseEntity findQnA(@RequestParam(required = false) Long id ){
        if(id == null){
            return ResponseEntity.ok(qnaService.findQnA());
        }
        else{
            return ResponseEntity.ok(qnaService.findQnA(id));
        }
    }

    /**
     * 질문 등록
     * @param request
     * @return
     */
    @PostMapping("qna") // title flag fields description score filelink filename
    public ResponseEntity<QnA> saveQnA(@RequestBody QnASaveRequest request){
        return new ResponseEntity<QnA>(qnaService.saveQnA(request), HttpStatus.OK);
    }

    /**
     * 질문 삭제
     * @param id
     * @return
     */
    @DeleteMapping("qna")
    public ResponseEntity deleteQnA(@RequestParam(required = true) Long id){
        qnaService.deleteQnA(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 질문 수정
     * @param id
     * @param request
     * @return
     */
    @PutMapping("qna")
    public ResponseEntity<QnA> updateQnA(@RequestParam Long id, @RequestBody QnASaveRequest request){
        return ResponseEntity.ok(qnaService.updateQnA(id, request));
    }

}
