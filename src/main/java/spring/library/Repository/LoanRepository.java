package spring.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.library.Domain.Book;
import spring.library.Domain.Loan;
import spring.library.Domain.Member;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByBookAndMemberAndReturned(Book book, Member member, boolean returned);

}
