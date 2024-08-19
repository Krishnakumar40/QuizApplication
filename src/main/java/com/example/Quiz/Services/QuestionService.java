package com.example.Quiz.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Quiz.Models.Questions;
import com.example.Quiz.Repo.QuestionsRepo;



@Service 
public class QuestionService {
	
	@Autowired 
	private QuestionsRepo questionsRepo;

	public ResponseEntity<List<Questions>> getallquestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questionsRepo.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Questions>> getallJavaQuestions(String category) {
		try {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(questionsRepo.findBycategory(category),HttpStatus.OK );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questions questions) {
		try {
		questionsRepo.save(questions);
		return new  ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>("Problem while adding",HttpStatus.BAD_REQUEST);
		
	}

	public String putQuestion(Questions questions) {
		// TODO Auto-generated method stub
		questionsRepo.save(questions);
		return "changed successfully";
	}

	public String deleteQuestion(int id) {
		// TODO Auto-generated method stub
		questionsRepo.deleteById(id);
		return "deleted";
	}
	
	

}
