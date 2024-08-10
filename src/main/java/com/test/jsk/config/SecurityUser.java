package com.test.jsk.config;

import com.test.jsk.vo.MemberVO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.Collections;

@Getter
@Setter
public class SecurityUser extends User {

    @Serial
    private static final long serialVersionUID = 1L;
    private final MemberVO member;


    public SecurityUser(MemberVO memberVO){
        super(
                memberVO.getMemId(),
                memberVO.getMemPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(memberVO.getMemRole()))
        );
        this.member = memberVO;
    }

}
