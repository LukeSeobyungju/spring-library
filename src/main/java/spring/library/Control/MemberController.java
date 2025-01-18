package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import spring.library.Repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

}
