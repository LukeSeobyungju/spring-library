package spring.library.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.DTO.MemberDto;
import spring.library.DTO.MemberRequest;
import spring.library.DTO.MemberResponse;
import spring.library.Domain.Member;
import spring.library.Repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;


    public String addMember(MemberRequest memberRequest) {
        memberRepository.save(Member.from(memberRequest));
        return "추가 완료";
    }


    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream().map(MemberDto::from).toList().stream().map(MemberResponse::from).toList();
    }


    @Transactional
    public String updateMember(Long memberId, MemberRequest memberRequest) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if(member == null) return "오류";
        member.update(memberRequest);
        return "수정 완료";
    }


    public String deleteMember(Long memberId) {
        if(memberRepository.existsById(memberId)){
            memberRepository.deleteById(memberId);
            return "삭제 완료";
        }
        else return "오류";
    }


}
