package spring.library.Domain;


import jakarta.persistence.*;
import lombok.*;
import spring.library.DTO.MemberDto;
import spring.library.DTO.MemberRequest;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    @OneToMany(
        mappedBy="member",
        fetch=FetchType.LAZY,
        cascade=CascadeType.ALL,
        orphanRemoval=true)
    private List<Loan> books=new ArrayList<>();


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
        setName(memberRequest.getName());
        setStuNumber(memberRequest.getStuNumber());
        setFeature(memberRequest.getFeature());
        setEmail(memberRequest.getEmail());
        setPhoneNumber(memberRequest.getPhoneNumber());
    }
}
