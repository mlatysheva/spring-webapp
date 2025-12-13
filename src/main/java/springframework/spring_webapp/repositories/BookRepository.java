package springframework.spring_webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.spring_webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
