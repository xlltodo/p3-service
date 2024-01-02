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
 * 包裹空间属性表
 * @TableName package_spatial_attribute
 */
@TableName(value ="package_spatial_attribute")
@Data
@Accessors(chain = true)
public class PackageSpatialAttributeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3541668850777274924L;

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

}