package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

@SpringBootTest

public class UpdateQuestionUseCaseTest {

    @SpyBean
    private UpdateQuestionUseCase updateQuestionUseCase;

    @MockBean
    private QuestionRepository repository;

    @Test
    void updateQuestionTest(){

        var questionDTO = new QuestionDTO("1","1","Quien soy yo?", "OPEN","TECHNOLOGY AND COMPUTER", "leonardo@gmail.com", 1, 2, List.of("1"));
        var question = new Question();
        question.setId("1");
        question.setUserId("1");
        question.setQuestion("Quien soy yo?");
        question.setType("OPEN");
        question.setCategory("TECNOLOGIA");
        question.setNumberOfReviews(1);
        question.setSumOfReviewScores(2);
        question.setUserReviews(List.of("x1","x2"));
        question.setUserEmail("leonardo@gmail.com");

        when(repository.save(Mockito.any(Question.class))).thenReturn(Mono.just(question));

        var result = updateQuestionUseCase.apply(questionDTO);

        Assertions.assertEquals(Objects.requireNonNull(result.block()).getId(),"1");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getUserId(),"1");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getQuestion(),"Quien soy yo?");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getType(),"OPEN");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getCategory(),"TECNOLOGIA");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getUserEmail(),"leonardo@gmail.com");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getNumberOfReviews(),1);
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getSumOfReviewScores(),2);

    }

}
