package com.zheye.question.domain.repository;

import com.zheye.question.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author shkstart
 * @create 2022-04-05 12:27
 */
public interface QuestionRepository extends JpaRepository<Question, String> {

}
