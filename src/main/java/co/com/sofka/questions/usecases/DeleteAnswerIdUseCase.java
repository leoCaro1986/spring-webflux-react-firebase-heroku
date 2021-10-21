package co.com.sofka.questions.usecases;

import co.com.sofka.questions.reposioties.AnswerRepository;
import com.mongodb.Function;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class DeleteAnswerIdUseCase  implements Function<String, Mono<Void>> {

    private  final AnswerRepository answerRepository;
    public DeleteAnswerIdUseCase(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @Override
    public  Mono<Void> apply(String id){
        Objects.requireNonNull(id, "id in required");
        return answerRepository.deleteById(id);
    }
}
