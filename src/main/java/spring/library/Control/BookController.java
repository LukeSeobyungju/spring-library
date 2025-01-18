package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import spring.library.Service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


}
