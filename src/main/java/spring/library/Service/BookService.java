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


    public String addBook(BookRequest bookRequest) {
        bookRepository.save(Book.from(bookRequest));
        return "추가 완료";
    }


    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(BookDto::from).toList().stream().map(BookResponse::from).toList();
    }


    @Transactional
    public String updateBook(Long bookId, BookRequest bookRequest) {
        Book book=bookRepository.findById(bookId).orElse(null);
        if(book!=null){
            book.update(bookRequest);
            return "수정 완료";
        }
        else return "오류";
    }


    public String deleteBook(Long bookId) {
        if(bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return "삭제 완료";
        }
        else return "오류";
    }


}
