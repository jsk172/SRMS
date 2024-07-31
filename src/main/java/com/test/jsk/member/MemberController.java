package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /*@GetMapping("/{memId}")
    public MemberVO getMemberById(@PathVariable String memId){
        return memberService.findByMemId(memId);
    }*/
}
