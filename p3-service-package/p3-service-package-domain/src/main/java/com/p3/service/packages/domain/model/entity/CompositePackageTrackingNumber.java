package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.CompositePackageTrackingNumberMapper;

import java.time.LocalDateTime;

public class CompositePackageTrackingNumber {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 集包编号
     */
    private String compositePackageCode;

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

    public CompositePackageTrackingNumber(String id, String compositePackageCode, String numberType, String trackingNumber, LocalDateTime creationTime) {
        this.id = id;
        this.compositePackageCode = compositePackageCode;
        this.numberType = numberType;
        this.trackingNumber = trackingNumber;
        this.creationTime = creationTime;
    }

    public <T> T mapWith(CompositePackageTrackingNumberMapper<T> mapper) {
        return mapper.map(this.id, this.compositePackageCode, this.numberType, this.trackingNumber, this.creationTime);
    }

    public CompositePackageTrackingNumberTypeEnum getNumberType() {
        return CompositePackageTrackingNumberTypeEnum.valueOf(this.numberType);
    }

    public String getTrackingNumber() {
        return this.trackingNumber;
    }
}