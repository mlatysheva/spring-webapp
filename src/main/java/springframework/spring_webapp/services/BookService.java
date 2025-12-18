package springframework.spring_webapp.services;

import springframework.spring_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
