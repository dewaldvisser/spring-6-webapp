package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRespository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRespository bookRespository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRespository bookRespository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author authorEric = new Author();
        authorEric.setFirstName("Eric");
        authorEric.setLastName("Evans");

        Book bookDdd = new Book();
        bookDdd.setTitle("Domain Driven Design");
        bookDdd.setIsbn("123456");

        Author ericSaved = authorRepository.save(authorEric);
        Book bookDddSaved = bookRespository.save(bookDdd);

        Author authorRod = new Author();
        authorRod.setFirstName("Rod");
        authorRod.setLastName("Johnson");

        Book bookNoEjb = new Book();
        bookNoEjb.setTitle("J2EE Development without EJB");
        bookNoEjb.setIsbn("4566789");

        Author rodSaved = authorRepository.save(authorRod);
        Book bookNoEjbSaved = bookRespository.save(bookNoEjb);

        ericSaved.getBooks().add(bookDddSaved);
        rodSaved.getBooks().add(bookNoEjbSaved);
        bookDddSaved.getAuthors().add(ericSaved);
        bookNoEjb.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Oreilly");
        publisher.setAddress("123 Oxford Street");
        publisher.setCity("New York");
        publisher.setZip("NY");

        Publisher publisherSaved = publisherRepository.save(publisher);

        bookDddSaved.setPublisher(publisherSaved);
        bookNoEjbSaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRespository.save(bookDddSaved);
        bookRespository.save(bookNoEjbSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRespository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
