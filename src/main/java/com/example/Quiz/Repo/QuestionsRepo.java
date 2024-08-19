package com.example.Quiz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Quiz.Models.Questions;

@Repository 
public interface QuestionsRepo extends JpaRepository<Questions,Integer > {

	List<Questions> findBycategory(String category);

	@Query(value = "SELECT * FROM questions q where q.category=:category  order by rand() limit :numQ",nativeQuery = true)
	List<Questions> findQuestionByCategory(String category, Integer numQ);

}
