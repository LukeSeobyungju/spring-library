package spring.library.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private String name;
    private long stuNumber;
    private String feature;
    private String email;
    private String phoneNumber;

}
