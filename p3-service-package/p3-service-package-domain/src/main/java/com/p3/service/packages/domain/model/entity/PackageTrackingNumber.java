package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.p3.service.packages.domain.model.mapper.PackageTrackingNumberMapper;
import lombok.Data;

public class PackageTrackingNumber {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 包裹编号
     */
    private String packageCode;

    /**
     * 单号类型
     */
    private String numberType;

    /**
     * 单号
     */
    private String trackingNumber;

    /**
     * 生成单号时间
     */
    private LocalDateTime creationTime;

    public PackageTrackingNumber(String id, String packageCode, String numberType, String trackingNumber, LocalDateTime creationTime) {
        this.id = id;
        this.packageCode = packageCode;
        this.numberType = numberType;
        this.trackingNumber = trackingNumber;
        this.creationTime = creationTime;
    }

    public <T> T mapWith(PackageTrackingNumberMapper<T> mapper) {
        return mapper.map(this.id, this.packageCode, this.numberType, this.trackingNumber, this.creationTime);
    }

}