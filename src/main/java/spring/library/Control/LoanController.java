package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.DTO.LoanDto;
import spring.library.DTO.LoanDtoHistory;
import spring.library.DTO.LoanRequest;
import spring.library.Domain.Loan;
import spring.library.Service.BookService;
import spring.library.Service.LoanService;
import spring.library.Service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {


    private final LoanService loanService;


    @PostMapping("/books/{bookId}/checkout")
    public ResponseEntity<String> checkoutBook(@PathVariable long bookId, @RequestBody LoanRequest loanRequest) {
        return ResponseEntity.ok().body(loanService.checkoutBook(bookId,loanRequest));
    }



    @GetMapping("/books/checkout")
    public ResponseEntity<List<LoanDto>> checkoutList(@RequestParam("memberId") long memberId) {
        return ResponseEntity.ok().body(loanService.checkoutList(memberId));
    }



    @GetMapping("/books/history")
    public ResponseEntity<List<LoanDtoHistory>> checkoutHistory(@RequestParam("memberId") long memberId) {
        return ResponseEntity.ok().body(loanService.checkoutHistory(memberId));
    }



    @PutMapping("books/{bookId}/return")
    public ResponseEntity<String> returnBook(@PathVariable long bookId, @RequestBody LoanRequest loanRequest) {
        return ResponseEntity.ok().body(loanService.returnBook(bookId,loanRequest));
    }



    @PutMapping("books/{bookId}/renewal")
    public ResponseEntity<String> checkoutRenewal(@PathVariable long bookId, @RequestBody LoanRequest loanRequest) {
        return ResponseEntity.ok().body(loanService.checkoutRenewal(bookId,loanRequest));
    }


}
