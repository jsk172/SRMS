package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memId}")
    public MemberVO getMemberById(@PathVariable String memId){
        return memberService.findByMemId(memId);
    }

    //회원 가입
    @GetMapping("/member/join")
    public String joinForm(){
        return"/member/join";
    }
    @PostMapping("/member/join")
    public String join(@ModelAttribute MemberVO memberVO){ //@valid : 필드의 유효성 검사
        memberService.memAdd(memberVO);
        return "redirect:/";
    }

    //회원 목록
    @GetMapping("/member/view")
    public String view(MemberVO memberVO){
        List<MemberVO> memberVOList = memberService.findAll();
        return"/member/view";
    }

    //회원 상세보기
    @GetMapping("/member/{name}")
    public String detail(@PathVariable Integer memSeq, Model model){
        MemberVO memberVO = memberService.findByMemSeq(memSeq);
        return "member/detail";
    }

    //회원 삭제
    @GetMapping("/member/delete/{name}")
    public String delete(@PathVariable Integer memSeq){
        memberService.deleteById(memSeq);
        return "redirect:/member/list";
    }
    
    //회원 수정
    @GetMapping("/member/update")
    public String updateForm(MemberVO memberVO){
        return "member/update";
    }
    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberVO memberVO){
        memberService.update(memberVO);
        return "redirect:/member/" + memberVO.getMemSeq();
    }


}
