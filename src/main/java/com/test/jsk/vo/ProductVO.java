package com.test.jsk.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
@Data
@Alias("productVO")
public class ProductVO {
    private long proSeq;
    private String proName;
    private int proCount;
    private int proPrice;
    private String filePath;
    private String fileImage;
    private Date proRegDate;
    private Date proUpdateDate;
    private Date manufacDate;
}
