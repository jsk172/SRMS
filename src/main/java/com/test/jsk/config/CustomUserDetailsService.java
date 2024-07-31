/*
package com.test.jsk.config;

import com.test.jsk.member.MemberMapper;
import com.test.jsk.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO member = memberMapper.findByMemId(username);
        if (member == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Fetch the role from the mem_role field
        String role = member.getMemRole();

        // Convert the role to GrantedAuthority
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));

        return new org.springframework.security.core.userdetails.User(
                member.getMemId(),
                member.getMemPassword(),
                authorities
        );
    }
}
*/
