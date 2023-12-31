package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 包裹质检单关联包裹表
 * @TableName quality_control_sheet_package
 */
@TableName(value ="quality_control_sheet_package")
@Data
@Accessors(chain = true)
public class QualityControlSheetPackageEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2941410823879444390L;

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
     * 重量
     */
    @TableField(value = "weight")
    private Double weight;

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
     * 数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 品名
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 品牌名称
     */
    @TableField(value = "brand_name")
    private String brandName;

    /**
     * 一级货品类型
     */
    @TableField(value = "primary_goods_type")
    private String primaryGoodsType;

    /**
     * 二级货品类型
     */
    @TableField(value = "secondary_goods_type")
    private String secondaryGoodsType;

}