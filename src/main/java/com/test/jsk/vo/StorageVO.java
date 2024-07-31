package com.test.jsk.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("storageVO")
public class StorageVO {
    private long storSeq;
    private long memSeq;
    private long proSeq;
    private Date storDate;
}
