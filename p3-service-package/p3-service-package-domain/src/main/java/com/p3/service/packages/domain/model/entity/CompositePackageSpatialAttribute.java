package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.CompositePackageSpatialAttributeMapper;

import java.time.LocalDateTime;

public class CompositePackageSpatialAttribute {
    

    /**
     * 主键ID
     */
    private String id;

    /**
     * 集包编号
     */
    private String compositePackageCode;

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

    public CompositePackageSpatialAttribute(String id, String compositePackageCode, Double length, Double width, Double height, Double volume, Double weight, LocalDateTime measurementTime) {
        this.id = id;
        this.compositePackageCode = compositePackageCode;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
        this.weight = weight;
        this.measurementTime = measurementTime;
    }

    public <T> T mapWith(CompositePackageSpatialAttributeMapper<T> mapper) {
        return mapper.map(this.id, this.compositePackageCode, this.length, this.width, this.height, this.volume, this.weight, this.measurementTime);
    }
}