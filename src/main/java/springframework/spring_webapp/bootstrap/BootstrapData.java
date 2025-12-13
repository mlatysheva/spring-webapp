package springframework.spring_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring_webapp.domain.Author;
import springframework.spring_webapp.domain.Book;
import springframework.spring_webapp.repositories.AuthorRepository;
import springframework.spring_webapp.repositories.BookRepository;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author bradbury = new Author();
        bradbury.setFirstName("Ray");
        bradbury.setLastName("Bradbury");

        Author evans = new Author();
        evans.setFirstName("Eric");
        evans.setLastName("Evans");

        Book fahrenheit451 = new Book();
        fahrenheit451.setTitle("Fahrenheit 451");
        fahrenheit451.setIsdn("1234567");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsdn("32454345");

        Author bradburySaved = authorRepository.save(bradbury);
        Author  evansSaved = authorRepository.save(evans);
        Book fahrenheit451Saved = bookRepository.save(fahrenheit451);
        Book dddSaved = bookRepository.save(ddd);

        // Create association between authors and books
        bradburySaved.getBooks().add(fahrenheit451Saved);
        evansSaved.getBooks().add(dddSaved);

        // Persist the author-book associations
        authorRepository.save(bradburySaved);
        authorRepository.save(evansSaved);

        System.out.println("In BootstrapData");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
