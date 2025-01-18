package spring.library.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.Repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


}
