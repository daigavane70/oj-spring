package com.sprint.server.controller;

import com.sprint.common.response.HttpApiResponse;
import com.sprint.common.response.HttpErrorResponse;
import com.sprint.repository.entity.Question;
import com.sprint.repository.repositories.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/question")
    public HttpApiResponse<List<Question>> getAllQuestions() {
        try {
            log.info("[QuestionController : getAllQuestions] request of get all questions");
            List<Question> questions = questionRepository.findAll();
            log.info("[QuestionController : getAllQuestions] returning all questions: {}", questions);
            return new HttpApiResponse<>(questions);
        } catch (Exception e) {
            log.error("[getAllQuestions] Error: {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }

    @GetMapping("/question/{id}")
    public HttpApiResponse getQuestionById(@PathVariable Long id) {
        try {
            log.info("[QuestionController : getQuestionById] request for question by id: {}", id);
            Optional<Question> question = questionRepository.findById(id);
            log.info("[QuestionController : getQuestionById] question found for id: {}, question: {}", id, question);
            if (question.isEmpty())
                throw new Exception("No question found for id: " + id);
            return new HttpApiResponse<>(question);
        } catch (Exception e) {
            log.error("[QuestionController : getQuestionById] Error: {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }

    @PostMapping(value = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpApiResponse createQuestion(@RequestBody Question question) {
        try {
            log.info("[QuestionController : createQuestion] received request to create question for payload: {}", question);
            Question newQuestion = questionRepository.save(question);
            log.info("[QuestionController : createQuestion] new Question created: {}", newQuestion);
            return new HttpApiResponse<>(question);
        } catch (Exception e) {
            log.error("[QuestionController : createQuestion] Error: {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }

    @PutMapping(value = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpApiResponse updateQuestion(@RequestBody Question questionRequest) {
        try {
            log.info("[QuestionController : updateQuestion] received request to update question for payload: {}", questionRequest);
            Optional<Question> searchedQuestion = questionRepository.findById(questionRequest.getId());
            if (searchedQuestion.isEmpty()) {
                log.error("[QuestionController : updateQuestion] Error: question not found for request: {}", questionRequest);
                return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, "No question exist with id: " + questionRequest.getId()));
            }
            Question newQuestion = questionRepository.save(questionRequest);
            log.info("[QuestionController : updateQuestion] new Question created: {}", newQuestion);
            return new HttpApiResponse<>(questionRequest);
        } catch (Exception e) {
            log.error("[QuestionController : updateQuestion] UNABLE_TO_UPDATE_QUESTION Error: {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }
}
