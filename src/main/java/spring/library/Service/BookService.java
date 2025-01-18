package spring.library.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.library.DTO.BookDto;
import spring.library.DTO.BookRequest;
import spring.library.DTO.BookResponse;
import spring.library.Domain.Book;
import spring.library.Repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponse addBook(BookRequest bookRequest) {
        return BookResponse.from(BookDto.from(bookRepository.save(Book.from(bookRequest))));
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(BookDto::from).toList().stream().map(BookResponse::from).toList();
    }

    @Transactional
    public BookResponse updateBook(Long bookId, BookRequest bookRequest) {
        Book book=bookRepository.findById(bookId).orElse(null);
        book.update(bookRequest);
        return BookResponse.from(BookDto.from(book));
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
