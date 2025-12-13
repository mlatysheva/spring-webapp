package springframework.spring_webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.spring_webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
