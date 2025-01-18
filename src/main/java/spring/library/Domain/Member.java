package spring.library.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import spring.library.DTO.MemberDto;
import spring.library.DTO.MemberRequest;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;


    public static Member from(MemberRequest memberRequest){
        return Member.builder()
                .name(memberRequest.getName())
                .stuNumber(memberRequest.getStuNumber())
                .feature(memberRequest.getFeature())
                .email(memberRequest.getEmail())
                .phoneNumber(memberRequest.getPhoneNumber())
                .build();
    }
    public void update(MemberRequest memberRequest){
        this.name=memberRequest.getName();
        this.stuNumber=memberRequest.getStuNumber();
        this.feature=memberRequest.getFeature();
        this.email=memberRequest.getEmail();
        this.phoneNumber=memberRequest.getPhoneNumber();
    }
}
