package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 包裹质检单商品表
 * @TableName quality_control_sheet_goods_info
 */
@TableName(value ="quality_control_sheet_goods_info")
@Data
public class QualityControlSheetGoodsInfoEntity implements Serializable {

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 质检单编号
     */
    @TableField(value = "sheet_code")
    private String sheetCode;

    /**
     * 品名
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 货品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 货物类型
     */
    @TableField(value = "goods_type")
    private String goodsType;

    /**
     * 规格
     */
    @TableField(value = "specification")
    private String specification;

    /**
     * 发货数量
     */
    @TableField(value = "shipment_quantity")
    private Integer shipmentQuantity;

    /**
     * 单价
     */
    @TableField(value = "unit_price")
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    @TableField(value = "total_price")
    private BigDecimal totalPrice;

    /**
     * 二级货品类型
     */
    @TableField(value = "image_url")
    private String imageUrl;

}