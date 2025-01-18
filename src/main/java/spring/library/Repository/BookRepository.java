package spring.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.library.Domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
