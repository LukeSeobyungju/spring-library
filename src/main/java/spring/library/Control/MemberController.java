package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.DTO.MemberRequest;
import spring.library.DTO.MemberResponseNoId;
import spring.library.DTO.MemberResponse;
import spring.library.Service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponseNoId> addMember(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok().body(memberService.addMember(memberRequest));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> getAllMembers(){
        return ResponseEntity.ok().body(memberService.getAllMembers());
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseNoId> updateMember(@PathVariable Long memberId, @RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok().body(memberService.updateMember(memberId,memberRequest));
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseNoId> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().build();
    }
}
