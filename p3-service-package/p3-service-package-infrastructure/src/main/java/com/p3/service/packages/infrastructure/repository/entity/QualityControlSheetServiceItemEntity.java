package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 包裹质检单服务项目
 * @TableName quality_control_sheet_service_item
 */
@TableName(value ="quality_control_sheet_service_item")
@Data
@Accessors(chain = true)
public class QualityControlSheetServiceItemEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7894934066681714819L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 质检单ID
     */
    @TableField(value = "sheet_id")
    private String sheetId;

    /**
     * 服务类型
     */
    @TableField(value = "service_type")
    private String serviceType;

    /**
     * 服务名称
     */
    @TableField(value = "service_name")
    private String serviceName;

    /**
     * 服务费
     */
    @TableField(value = "fee")
    private BigDecimal fee;

    /**
     * 已开通标识（0否1是）
     */
    @TableField(value = "activated")
    private Integer activated;

    /**
     * 创建时间
     */
    @TableField(value = "creation_time")
    private LocalDateTime creationTime;

}