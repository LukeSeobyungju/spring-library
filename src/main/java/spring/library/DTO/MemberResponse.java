package spring.library.DTO;

import lombok.*;

@Getter
@Setter
@Builder
public class MemberResponse {
    private long id;
    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberResponse from(MemberDto memberDto) {
        return MemberResponse.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .stuNumber(memberDto.getStuNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}
