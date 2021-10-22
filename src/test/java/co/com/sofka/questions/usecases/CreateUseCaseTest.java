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
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateUseCaseTest {
    @SpyBean
    private CreateUseCase createUseCase;

    @MockBean
    private QuestionRepository repository;

    @Test
    void createResource(){

        var resourceDT0 = new QuestionDTO("xxx","yyy","React o Angular","tecnologia",
                "TECNOLOGIA","juandi@gmail.com",2, 11, List.of("1") );

        var resource = new Question();
        resource.setId("xxx");
        resource.setUserId("yyy");
        resource.setQuestion("React o Angular");
        resource.setType("tecnologia");
        resource.setCategory("TECNOLOGIA");
        resource.setNumberOfReviews(1);
        resource.setSumOfReviewScores(2);
        resource.setUserReviews(Arrays.asList("x1","x2"));
        resource.setUserEmail("juandi@gmail.com");

        when(repository.save(Mockito.any(Question.class))).thenReturn(Mono.just(resource));

        var result = createUseCase.apply(resourceDT0);

        Assertions.assertEquals(Objects.requireNonNull(result.block()),"xxx");
    }
}