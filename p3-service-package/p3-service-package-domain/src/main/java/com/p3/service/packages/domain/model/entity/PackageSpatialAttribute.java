package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.p3.service.packages.domain.model.mapper.PackageSpatialAttributeMapper;

import java.time.LocalDateTime;

public class PackageSpatialAttribute {

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 包裹编号
     */
    @TableField(value = "package_code")
    private String packageCode;

    /**
     * 长
     */
    @TableField(value = "length")
    private Double length;

    /**
     * 宽
     */
    @TableField(value = "width")
    private Double width;

    /**
     * 高
     */
    @TableField(value = "height")
    private Double height;

    /**
     * 体积
     */
    @TableField(value = "volume")
    private Double volume;

    /**
     * 重量
     */
    @TableField(value = "weight")
    private Double weight;

    /**
     * 计量时间
     */
    @TableField(value = "measurement_time")
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