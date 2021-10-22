package co.com.sofka.questions.reposioties;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<SecurityProperties.User, String> {


}
