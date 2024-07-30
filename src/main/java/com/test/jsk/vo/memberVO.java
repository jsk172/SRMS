package com.test.jsk.vo;

import lombok.Data;

import java.util.Date;

@Data
public class memberVO {
    private int memSeq;
    private String memId;
    private String memPassword;
    private String memEmail;
    private int memPhone;
    private Date memBirth;
    private String memName;
    private int memNum;
    private Date memRegDate;
    private Date memUpdateDate;
}
