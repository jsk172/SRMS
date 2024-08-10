package com.test.jsk.member;

import com.test.jsk.config.SecurityUser;
import com.test.jsk.vo.MemberVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    //로그인 폼
    @GetMapping("/login")
    public String loginForm(){
        return "login";
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
    @GetMapping("/member/list")
    public String view(MemberVO memberVO){
        List<MemberVO> memberVOList = memberService.findAll();
        return"/member/list";
    }

    //회원 상세보기
    @GetMapping("/member/view/{memSeq}")
    public String detail(@PathVariable Long memSeq, Model model){
        //로그인 여부 확인
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || (authentication.getPrincipal() instanceof UserDetails)){
            return "redirect:/login";
        }
        UserDetails userDetails = (SecurityUser) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

        MemberVO memberVO = memberService.memView(memSeq);
        if(memberVO == null){
            return "redirect:/";
        }

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if(isAdmin || memberVO.getMemId().equals(currentUserName)){
            model.addAttribute("member", memberVO);
            return "member/view";
        } else{
            return "redirect:/";
        }
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
