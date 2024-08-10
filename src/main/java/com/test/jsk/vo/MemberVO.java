package com.test.jsk.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("memberVO")
public class MemberVO {
    private Long memSeq;
    private String memId;
    private String memPassword;
    private String memEmail;
    private String memPhone;
    private String memBirth;
    private String memName;
    private String memNum;
    private Date memRegDate;
    private Date memUpdateDate;
    private String memRole;
}
