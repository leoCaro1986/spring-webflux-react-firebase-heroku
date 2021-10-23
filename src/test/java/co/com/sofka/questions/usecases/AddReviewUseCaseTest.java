package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.collections.Review;
import co.com.sofka.questions.model.QuestionDTO;

import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AddReviewUseCaseTest {
    @MockBean
    QuestionRepository questionRepository;

    @Mock
    UpdateQuestionUseCase updateQuestionUseCase;

    @SpyBean
    AddReviewUseCase addReviewUseCase;

    @Test
    @DisplayName("Add satisfaction review")
    void setAddReviewTest(){
        List<String> listParameter = new ArrayList<>();
        var questionDTO = new QuestionDTO("01","u01","test?","test","test@gmail");

        var resource = new Question();
        resource.setId("1234drt");
        resource.setUserId("1234");
        resource.setQuestion("Que es un Dns");
        resource.setType("OPEN (LONG OPEN BOX)");
        resource.setCategory("SOFTWARE DEVELOPMENT");
        resource.setNumberOfReviews(1);
        resource.setSumOfReviewScores(1);
        resource.setUserReviews(listParameter);
        resource.setUserEmail("santiago@gmail.com");

        Mockito.when(questionRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(resource));
        Mockito.when(updateQuestionUseCase.apply(questionDTO)).thenReturn(Mono.just(questionDTO));
        Mockito.when(questionRepository.save(Mockito.any(Question.class))).thenReturn(Mono.just(resource));

        var review = new Review();
        review.setUserId("1234");
        review.setScore("3");
        review.setQuestionId("1234drt");

        var resultQuestionDTO = addReviewUseCase.addReview(review);
        System.out.println(resultQuestionDTO);
        assert resultQuestionDTO != null;
        Assertions.assertEquals(resultQuestionDTO.block().getId(), resource.getId());
        Assertions.assertEquals(resultQuestionDTO.block().getCategory(), resource.getCategory());
        Assertions.assertEquals(resultQuestionDTO.block().getQuestion(), resource.getQuestion());


    }
}