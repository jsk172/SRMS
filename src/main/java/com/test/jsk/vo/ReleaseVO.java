package com.test.jsk.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("releaseVO")
public class ReleaseVO {
    private long relSeq;
    private long memSeq;
    private long proSeq;
    private Date relDate;
}
