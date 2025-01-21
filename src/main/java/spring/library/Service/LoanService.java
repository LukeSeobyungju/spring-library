package spring.library.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.library.DTO.LoanDto;
import spring.library.DTO.LoanDtoHistory;
import spring.library.DTO.LoanRequest;
import spring.library.Domain.Book;
import spring.library.Domain.Loan;
import spring.library.Domain.Member;
import spring.library.Repository.BookRepository;
import spring.library.Repository.LoanRepository;
import spring.library.Repository.MemberRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public String checkoutBook(long bookId, LoanRequest loanRequest) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book.getStatus().equals("대출가능")){
            Member member = memberRepository.findById(loanRequest.getMemberId()).orElse(null);
            loanRepository.save(Loan.loan(member, book));
            book.statusChange();
            return "대출 완료";
        }
        else return "오류";

    }

    public List<LoanDto> checkoutList(long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        return member.getBooks().stream().filter(loan-> loan.isReturned()==false).map(LoanDto::from).toList();
    }

    public List<LoanDtoHistory> checkoutHistory(long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        return member.getBooks().stream().map(LoanDtoHistory::from).toList();
    }


    @Transactional
    public String returnBook(long bookId, LoanRequest loanRequest) {
        Member member = memberRepository.findById(loanRequest.getMemberId()).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);
        Loan loan = loanRepository.findByBookAndMemberAndReturned(book,member,false).orElse(null);
        if(loan!=null){
            book.statusChange();
            loan.returnLoan();
            return "반납 완료";
        }
        else return "오류";
    }

    @Transactional
    public String checkoutRenewal(long bookId, LoanRequest loanRequest) {
        Member member = memberRepository.findById(loanRequest.getMemberId()).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);
        Loan loan = loanRepository.findByBookAndMemberAndReturned(book,member,false).orElse(null);
        if(loan!=null && loan.renewable()){ //&& LocalDate.now().toString().equals(loan.getDueDate())
            loan.renew();
            return "연장 완료";
        }
        else return "오류";
    }


}
