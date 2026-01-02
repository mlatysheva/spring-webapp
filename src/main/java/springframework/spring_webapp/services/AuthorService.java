package springframework.spring_webapp.services;

import springframework.spring_webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
