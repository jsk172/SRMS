package com.test.jsk.config;

import com.test.jsk.member.MemberMapper;
import com.test.jsk.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberVO findMember = memberMapper.findByMemId(username);
        if (findMember == null) {
            throw new UsernameNotFoundException("존재하지 않는 아이디입니다.");
        }
        // UserDetails 객체 반환
        return new SecurityUser(findMember);
    }
}
