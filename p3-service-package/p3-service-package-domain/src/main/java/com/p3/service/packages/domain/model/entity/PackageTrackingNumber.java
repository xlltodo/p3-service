package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.p3.service.packages.domain.model.mapper.PackageTrackingNumberMapper;

import java.time.LocalDateTime;

public class PackageTrackingNumber {

    /**
     * 主键ID
     */
    @TableField(value = "id")
    private String id;

    /**
     * 包裹编号
     */
    @TableField(value = "package_code")
    private String packageCode;

    /**
     * 单号类型
     */
    @TableField(value = "number_type")
    private String numberType;

    /**
     * 单号
     */
    @TableField(value = "tracking_number")
    private String trackingNumber;

    /**
     * 生成单号时间
     */
    @TableField(value = "creation_time")
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