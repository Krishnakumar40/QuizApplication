package com.example.Quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quiz.Models.Questions;
import com.example.Quiz.Services.QuestionService;

@RestController 
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired 
	private QuestionService service;
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<Questions>> getallquestions() {
		return service.getallquestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Questions>> getallJavaQuestions(@PathVariable String  category){
		return service.getallJavaQuestions(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addquestion(@RequestBody Questions questions) {
		
		return service.addQuestion(questions);
	}
	
	@PutMapping("/add")
	public String putquestion(@RequestBody Questions questions) {
		return service.putQuestion(questions);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable int  id) {
		return service.deleteQuestion(id);
		
	}
	

}
