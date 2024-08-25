package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Long> {

}
