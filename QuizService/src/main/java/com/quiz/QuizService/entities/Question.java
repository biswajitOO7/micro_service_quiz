package com.quiz.QuizService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity   //  no need to save in database so removing database notations
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    // @Id  //  no need to save in database so removing database notations
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //  no need to save in database so removing database notations
    private Long questionId;
    private String question;

    //foreign key
    private Long quizId;

}