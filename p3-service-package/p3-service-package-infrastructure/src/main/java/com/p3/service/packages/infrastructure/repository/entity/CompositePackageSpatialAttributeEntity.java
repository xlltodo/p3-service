package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 集包空间属性表
 * @TableName composite_package_spatial_attribute
 */
@TableName(value ="composite_package_spatial_attribute")
@Data
@Accessors(chain = true)
public class CompositePackageSpatialAttributeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4081137072577285334L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 集包编号
     */
    @TableField(value = "composite_package_code")
    private String compositePackageCode;

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

}