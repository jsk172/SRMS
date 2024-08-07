package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberVO findByMemId(String memId) {
        return memberMapper.findByMemId(memId);
    }

    //회원 가입
    public void memAdd(MemberVO memberVO) {
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
