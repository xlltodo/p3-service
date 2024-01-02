package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 包裹追踪编号表
 * @TableName package_tracking_number
 */
@TableName(value ="package_tracking_number")
@Data
@Accessors(chain = true)
public class PackageTrackingNumberEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4082249161289801828L;

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

}