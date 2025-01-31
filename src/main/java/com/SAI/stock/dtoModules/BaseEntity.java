package com.SAI.stock.dtoModules;

import com.SAI.stock.commonUtil.CommonUtil;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private String createdBy;
    private String modifiedBy;
    private String createdon;
    private String modifiedOn;

    public void createEntity(String createdBy, String modifiedBy) {
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdon = CommonUtil.getCurrentDate();
        this.modifiedOn = CommonUtil.getCurrentDate();
    }
}
