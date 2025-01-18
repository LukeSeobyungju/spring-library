package spring.library.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.Repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
}
