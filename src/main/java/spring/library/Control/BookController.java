package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.library.DTO.MemberDto;
import spring.library.Service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;



}
