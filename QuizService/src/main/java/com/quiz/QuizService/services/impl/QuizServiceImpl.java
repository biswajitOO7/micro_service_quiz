package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service    // to mark a class as a service provider.
// This means that the class will be auto-detected by Spring and will be managed as a bean.
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;  // alt+enter // As we need repository here
    private QuestionClient questionClient; // from service

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz add(Quiz quiz) {
        //return null;
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        //return null;
        //return quizRepository.findAll();
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList =  quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));  // setting questions on each quiz. Which is comming from questionClient.java
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        //return null;
        //return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
        Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
        return quiz;
    }
}
