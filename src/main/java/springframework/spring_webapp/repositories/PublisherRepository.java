package springframework.spring_webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.spring_webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
