package com.example.Quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quiz.Models.QuestionWarpper;
import com.example.Quiz.Models.Response;
import com.example.Quiz.Services.QuizService;

@RestController 
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@PostMapping ("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title )
	{
		return service.createQuiz(category,numQ,title);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWarpper>> getuserQuestions(@PathVariable int id){
		return service.getuserQuestions(id);
		
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> getScore(@PathVariable int id,@RequestBody List<Response> response){
		return service.getScore(id,response);
	}
}
