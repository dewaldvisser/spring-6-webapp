package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.BookRespository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRespository bookRespository;

    public BookServiceImpl(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRespository.findAll();
    }
}
