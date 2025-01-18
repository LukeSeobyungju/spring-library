package spring.library.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
