package spring.library.DTO;

import lombok.*;
import spring.library.Domain.Loan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDtoHistory {

    private long bookId;
    private String title;
    private String author;
    private String loanDate;
    private String dueDate;
    private long renewalCount;
    private boolean returned;


    public static LoanDtoHistory from(Loan loan) {
        return LoanDtoHistory.builder()
                .bookId(loan.getBook().getId())
                .title(loan.getBook().getTitle())
                .author(loan.getBook().getAuthor())
                .loanDate(loan.getLoanDate())
                .dueDate(loan.getDueDate())
                .renewalCount(loan.getRenewalCount())
                .returned(loan.isReturned())
                .build();
    }
}
