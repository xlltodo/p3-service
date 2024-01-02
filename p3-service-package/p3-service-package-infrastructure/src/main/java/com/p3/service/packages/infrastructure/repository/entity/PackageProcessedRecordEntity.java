package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 包裹过机记录
 * @TableName package_processed_record
 */
@TableName(value ="package_processed_record")
@Data
@Accessors(chain = true)
public class PackageProcessedRecordEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7989875070488641210L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 原始票据号码或条码
     */
    @TableField(value = "tickets_num")
    private String ticketsNum;

    /**
     * 重量（千克）
     */
    @TableField(value = "weight")
    private Double weight;

    /**
     * 长度（毫米）
     */
    @TableField(value = "length")
    private Double length;

    /**
     * 宽度（毫米）
     */
    @TableField(value = "width")
    private Double width;

    /**
     * 高度（毫米）
     */
    @TableField(value = "height")
    private Double height;

    /**
     * 提及（立方毫米）
     */
    @TableField(value = "volume")
    private Double volume;

    /**
     * 设备名称
     */
    @TableField(value = "machine")
    private String machine;

}