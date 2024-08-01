package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberVO findByMemId(String memId) {
        return memberMapper.findByMemId(memId);
    }
}
