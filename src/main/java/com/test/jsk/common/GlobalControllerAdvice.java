package com.test.jsk.common;

import com.test.jsk.config.SecurityUser;
import com.test.jsk.vo.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    /*
    * 모든 컨트롤러에서 사용할 수 있는 공통적인 모델 속성을 정의
    * 현재 로그인 된 사용자 정보를 member로 모델에 추가
    */
    @ModelAttribute("member")
    public MemberVO getMember(){
        //로그인 된 사용자 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증된 사용자가 SecurityUser의 객체인지 확인
        if (authentication.getPrincipal() instanceof SecurityUser) {
            // SecurityUser로 캐스팅 한 후 MemberVO 객체를 반환
            SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
            return userDetails.getMember();
        }
        return null;
    }
}
