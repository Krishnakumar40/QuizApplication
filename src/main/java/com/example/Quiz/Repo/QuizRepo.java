package com.example.Quiz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Quiz.Models.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
