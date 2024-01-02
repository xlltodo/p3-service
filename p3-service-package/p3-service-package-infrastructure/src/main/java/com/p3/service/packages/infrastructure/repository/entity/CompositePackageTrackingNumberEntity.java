package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 集包追踪编号表
 * @TableName composite_package_tracking_number
 */
@TableName(value ="composite_package_tracking_number")
@Data
@Accessors(chain = true)
public class CompositePackageTrackingNumberEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5446101917980708102L;

    /**
     * 主键ID
     */
    @TableField(value = "id")
    private String id;

    /**
     * 集包编号
     */
    @TableField(value = "composite_package_code")
    private String compositePackageCode;

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

}