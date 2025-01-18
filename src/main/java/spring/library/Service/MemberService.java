package spring.library.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.DTO.MemberDto;
import spring.library.DTO.MemberRequest;
import spring.library.DTO.MemberResponse;
import spring.library.DTO.MemberResponseNoId;
import spring.library.Domain.Member;
import spring.library.Repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseNoId addMember(MemberRequest memberRequest) {
        return MemberResponseNoId.from(MemberDto.from(memberRepository.save(Member.from(memberRequest))));
    }

    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream().map(MemberDto::from).toList().stream().map(MemberResponse::from).toList();
    }

    @Transactional
    public MemberResponseNoId updateMember(Long memberId, MemberRequest memberRequest) {
        Member member = memberRepository.findById(memberId).orElse(null);
        member.update(memberRequest);
        return MemberResponseNoId.from(MemberDto.from(member));
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

}
