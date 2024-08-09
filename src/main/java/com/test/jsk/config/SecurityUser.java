package com.test.jsk.config;

import com.test.jsk.vo.MemberVO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class SecurityUser extends User {

    public SecurityUser(MemberVO memberVO){
        super(
                memberVO.getMemId(),
                memberVO.getMemPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("권한 : " + memberVO.getMemRole()))
        );
    }

}
