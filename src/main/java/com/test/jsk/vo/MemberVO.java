package com.test.jsk.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("memberVO")
public class MemberVO {
    private long memSeq;
    private String memId;
    private String memPassword;
    private String memEmail;
    private Integer memPhone;
    private Date memBirth;
    private String memName;
    private Integer memNum;
    private Date memRegDate;
    private Date memUpdateDate;
    private String memRole;
}
