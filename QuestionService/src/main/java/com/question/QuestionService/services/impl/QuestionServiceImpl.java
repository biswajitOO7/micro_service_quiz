package com.question.QuestionService.services.impl;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        //return null;
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        //return null;
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        //return null;
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        //return null;
        return questionRepository.findByQuizId(quizId);
    }
}
