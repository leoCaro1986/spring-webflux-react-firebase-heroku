package co.com.sofka.questions.reposioties;

import co.com.sofka.questions.collections.UserVote;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserVote, String> {

    Flux<UserVote> findByUserId(String userId);
}
