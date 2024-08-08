package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberVO findByMemId(String memId) {
        return memberMapper.findByMemId(memId);
    }

    //회원 가입
    public void memAdd(MemberVO memberVO) {
        String encPw = passwordEncoder.encode(memberVO.getMemPassword()); //비밀번호 암호화
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder memNum = new StringBuilder(length); //랜덤 문자열 생성
        for(int i=0; i<length; i++){
            int index = random.nextInt(characters.length());
            memNum.append(characters.charAt(index));
        }
        memberVO.setMemPassword(encPw); //암호화
        memberVO.setMemNum(memNum.toString()); //사번저장
        memberMapper.memAdd(memberVO);
    }

    //회원 목록
    public List<MemberVO> findAll() {
        List<MemberVO> memberList = memberMapper.findAll();
        //비어있는 memberDTOList를 생성
        List<MemberVO> memberVOList = new ArrayList<>();
        //List에 VO를 저장
        for(MemberVO memberVO : memberList){
            memberVOList.add(memberVO);
        }
        return memberVOList;
    }

    //회원 상세보기
    public MemberVO findByMemSeq(Integer memSeq) {
        memberMapper.findByMemSeq(memSeq);
        return null;
    }

    //회원 탈퇴
    public void deleteById(Integer memSeq) {
        memberMapper.deleteByName(memSeq);
    }

    //회원 수정
    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }
}
