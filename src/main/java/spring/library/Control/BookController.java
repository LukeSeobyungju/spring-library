package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.DTO.BookRequest;
import spring.library.DTO.BookResponse;
import spring.library.Service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok().body(bookService.addBook(bookRequest));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long bookId, @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok().body(bookService.updateBook(bookId,bookRequest));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

}
