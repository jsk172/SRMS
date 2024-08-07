package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberVO findByMemId(String memId);

    void memAdd(MemberVO memberVO);

    List<MemberVO> findAll();

    void findByMemSeq(Integer memSeq);

    void deleteByName(Integer memSeq);

    void update(MemberVO memberVO);
}
