package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class DeleteUseCaseTest {

    @MockBean
    private AnswerRepository answerRepository;
    @MockBean
    private QuestionRepository questionRepository;

    @SpyBean
    DeleteUseCase deleteQuestionUseCase;


    @Test
    void delete(){


        var resourceDT0 = new QuestionDTO("xxx","yyy","React o Angular","tecnologia",
                "TECNOLOGIA","juandi@gmail.com",2, 11, List.of("1") );

        var answer = new AnswerDTO();
        answer.setQuestionId("1");
        answer.setUserId("1");
        answer.setAnswer("It's a programming language");

        Mockito.when(questionRepository.deleteById("1")).thenReturn(Mono.empty());
        Mockito.when(answerRepository.deleteByQuestionId("1")).thenReturn(Mono.empty());

        var result = deleteQuestionUseCase.apply("1").block();

        Assertions.assertEquals(result,null);
    }

}