package spring.library.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import spring.library.DTO.BookRequest;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String author;
    private String publisher;
    private long publicationYear;
    private String classification;
    private String status;
    private long amount;


    public static Book from(BookRequest bookRequest){
        return Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .publisher(bookRequest.getPublisher())
                .publicationYear(bookRequest.getPublicationYear())
                .classification(bookRequest.getClassification())
                .status(bookRequest.getStatus())
                .amount(bookRequest.getAmount())
                .build();
    }

    public void update(BookRequest bookRequest){
        setTitle(bookRequest.getTitle());
        setAuthor(bookRequest.getAuthor());
        setPublisher(bookRequest.getPublisher());
        setPublicationYear(bookRequest.getPublicationYear());
        setClassification(bookRequest.getClassification());
        setStatus(bookRequest.getStatus());
        setAmount(bookRequest.getAmount());
    }

}
