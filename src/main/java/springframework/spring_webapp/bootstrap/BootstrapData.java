package springframework.spring_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring_webapp.domain.Author;
import springframework.spring_webapp.domain.Book;
import springframework.spring_webapp.domain.Publisher;
import springframework.spring_webapp.repositories.AuthorRepository;
import springframework.spring_webapp.repositories.BookRepository;
import springframework.spring_webapp.repositories.PublisherRepository;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        dddSaved.getAuthors().add(evansSaved);
        fahrenheit451Saved.getAuthors().add(bradburySaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Machaon");
        publisher.setAddress("Tverskaya Street 26");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        fahrenheit451Saved.setPublisher(savedPublisher);

        // Persist the author-book associations
        authorRepository.save(bradburySaved);
        authorRepository.save(evansSaved);

        // Persist the book-publisher associations
        bookRepository.save(fahrenheit451Saved);
        bookRepository.save(dddSaved);

        System.out.println("In BootstrapData");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
