package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // to mark a class as a service provider.
// This means that the class will be auto-detected by Spring and will be managed as a bean.
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;  // alt+enter // As we need repository here

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        //return null;
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        //return null;
        return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        //return null;
        return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
    }
}
