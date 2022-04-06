package com.zheye.question.domain.repository;

import com.zheye.question.core.DatabaseTestConfiguration;
import com.zheye.question.core.JpaRepositoryTest;
import com.zheye.question.domain.model.Question;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author shkstart
 * @create 2022-04-05 12:31
 */
@JpaRepositoryTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void repository_should_successfully_save_question() {
        Question question = new Question("UID_00001", "A Test title", "A test detail");
        Question saveQuestion = questionRepository.save(question);
        assertThat(saveQuestion.getId(), is(notNullValue()));
        assertThat(saveQuestion.getQuestionerId(), equalTo(question.getQuestionerId()));
        assertThat(saveQuestion.getTitle(), equalTo(question.getTitle()));
        assertThat(saveQuestion.getDetail(), equalTo(question.getDetail()));

    }
}