package spring.library.Control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.DTO.MemberRequest;
import spring.library.DTO.MemberResponse;
import spring.library.Service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;


    @PostMapping("/members")
    public ResponseEntity<String> addMember(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok().body(memberService.addMember(memberRequest));
    }


    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> getAllMembers(){
        return ResponseEntity.ok().body(memberService.getAllMembers());
    }


    @PutMapping("/members/{memberId}")
    public ResponseEntity<String> updateMember(@PathVariable Long memberId, @RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok().body(memberService.updateMember(memberId,memberRequest));
    }


    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId) {
        return ResponseEntity.ok().body(memberService.deleteMember(memberId));
    }


}
