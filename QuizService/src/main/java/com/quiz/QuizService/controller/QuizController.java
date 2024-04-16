package com.quiz.QuizService.controller;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
//@CrossOrigin("/quiz")
public class QuizController {
   // @Autowired
    private QuizService quizService;  // Taking all the methods from quizService.java

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    // create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){ //@RequestBody bind the request body to a method parameter.
        // This means that Spring will automatically deserialize the request body into a Java object and pass it to the method as a parameter.
        // any HTTP method, but it is most commonly used with POST and PUT requests
        return quizService.add(quiz);
    }
    @GetMapping()
    public List<Quiz> get(){
        return quizService.get();
    }
    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id ){
        return quizService.get(id);
    }

}
