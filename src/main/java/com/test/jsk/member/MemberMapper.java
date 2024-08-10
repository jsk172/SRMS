package com.test.jsk.member;

import com.test.jsk.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {

    MemberVO findByMemId(@Param("username") String username);

    void memAdd(MemberVO memberVO);

    List<MemberVO> findAll();

    MemberVO memView(Long memSeq);

    void deleteByName(Integer memSeq);

    void update(MemberVO memberVO);

    int isMemNumExists(String memNum);
}
