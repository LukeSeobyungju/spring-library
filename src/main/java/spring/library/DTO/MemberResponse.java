package spring.library.DTO;

import lombok.*;
import spring.library.Domain.Member;

@Getter
@Setter
@Builder
public class MemberResponse {
    private long memberId;
    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberResponse from(MemberDto memberDto) {
        return MemberResponse.builder()
                .memberId(memberDto.getMemberId())
                .name(memberDto.getName())
                .stuNumber(memberDto.getStuNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}
