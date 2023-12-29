package com.p3.service.packages.application.result;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 包裹空间属性表
 * @TableName package_spatial_attributes
 */
@Data
@TableName(value ="package_spatial_attributes")
public class PackageSpatialAttributesResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 6166020289849186415L;

    @Schema(description = "主键ID")
    @TableId(value = "id")
    private String id;

    @Schema(description = "包裹编号")
    @TableField(value = "package_code")
    private String packageCode;

    @Schema(description = "长")
    @TableField(value = "length")
    private Double length;

    @Schema(description = "宽")
    @TableField(value = "width")
    private Double width;

    @Schema(description = "高")
    @TableField(value = "height")
    private Double height;

    @Schema(description = "体积")
    @TableField(value = "volume")
    private Double volume;

    @Schema(description = "重量")
    @TableField(value = "weight")
    private Double weight;

    @Schema(description = "计量时间")
    @TableField(value = "measurement_time")
    private LocalDateTime measurementTime;

}