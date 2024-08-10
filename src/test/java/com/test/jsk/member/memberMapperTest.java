package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class memberMapperTest {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void test(){
        String username = "ksha86";
        MemberVO memberVO = memberMapper.findByMemId(username);
        System.out.println("memberVO: " + memberVO);
    }

    @Test void testView(){
        Long memSeq = 9L;
        MemberVO memberVO = memberMapper.memView(memSeq);
        System.out.println("정보 : " + memberVO);
    }
}
