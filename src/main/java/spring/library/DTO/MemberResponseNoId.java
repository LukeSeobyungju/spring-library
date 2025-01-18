package spring.library.DTO;

import lombok.Builder;

@Builder
public class MemberResponseNoId {
    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberResponseNoId from(MemberDto memberDto) {
        return MemberResponseNoId.builder()
                .name(memberDto.getName())
                .stuNumber(memberDto.getStuNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}
