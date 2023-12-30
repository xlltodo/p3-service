package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.PackageSpatialAttributeMapper;

import java.time.LocalDateTime;

public class PackageSpatialAttribute {
    
    /**
     * 主键ID
     */
    private String id;

    /**
     * 包裹编号
     */
    private String packageCode;

    /**
     * 长
     */
    private Double length;

    /**
     * 宽
     */
    private Double width;

    /**
     * 高
     */
    private Double height;

    /**
     * 体积
     */
    private Double volume;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 计量时间
     */
    private LocalDateTime measurementTime;

    public PackageSpatialAttribute(String id, String packageCode, Double length, Double width, Double height, Double volume, Double weight, LocalDateTime measurementTime) {
        this.id = id;
        this.packageCode = packageCode;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
        this.weight = weight;
        this.measurementTime = measurementTime;
    }

    public <T> T mapWith(PackageSpatialAttributeMapper<T> mapper) {
        return mapper.map(this.id, this.packageCode, this.length, this.width, this.height,
                this.volume, this.weight, this.measurementTime);
    }
}