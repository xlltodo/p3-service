package com.p3.service.packages.application.result;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 包裹追踪编号表
 * @TableName package_tracking_number
 */
@Data
@TableName(value ="package_tracking_number")
public class PackageTrackingNumberResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -5260708070225912574L;
    
    @Schema(description = "主键ID")
    @TableField(value = "id")
    private String id;

    @Schema(description = "包裹编号")
    @TableField(value = "package_code")
    private String packageCode;

    @Schema(description = "单号类型")
    @TableField(value = "number_type")
    private String numberType;

    @Schema(description = "单号")
    @TableField(value = "tracking_number")
    private String trackingNumber;

    @Schema(description = "生成单号时间")
    @TableField(value = "creation_time")
    private LocalDateTime creationTime;

}