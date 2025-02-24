package spring.library.DTO;

import lombok.*;
import spring.library.Domain.Member;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private long id;
    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .stuNumber(member.getStuNumber())
                .feature(member.getFeature())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

}
