package com.example.Quiz.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Quiz.Models.QuestionWarpper;
import com.example.Quiz.Models.Questions;
import com.example.Quiz.Models.Quiz;
import com.example.Quiz.Models.Response;
import com.example.Quiz.Repo.QuestionsRepo;
import com.example.Quiz.Repo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo repo;
	
	@Autowired
	QuestionsRepo questionRepo;

	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		// TODO Auto-generated method stub
		try {
			List<Questions> question= questionRepo.findQuestionByCategory(category,numQ);
		Quiz quiz =new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		
		repo.save(quiz);
		return new ResponseEntity<>("Quiz created",HttpStatus.CREATED);
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return new ResponseEntity<>("Quiz not created",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWarpper>> getuserQuestions(int id) {
		// TODO Auto-generated method stub
		try {
		Optional<Quiz> quiz=repo.findById(id);
		List<Questions> questionsfromDb = quiz.get().getQuestions();
		List<QuestionWarpper> questionforUser =new ArrayList<>();
		
		for(Questions q : questionsfromDb) {
			QuestionWarpper qWarpper=new QuestionWarpper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionforUser.add(qWarpper);
		}
		
		return new ResponseEntity<>(questionforUser,HttpStatus.OK);
		
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Integer> getScore(int id, List<Response> response) {
		// TODO Auto-generated method stub
		
		Quiz quiz=repo.findById(id).get();
		List<Questions> questions=quiz.getQuestions();
		int right=0;
		int i=0;
		
		for(Response r : response) {
			if(r.getResponse().equals(questions.get(i).getRightAnswer())){
				right+=1;
				
			}
			i++;
			
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	
		
	}



}
