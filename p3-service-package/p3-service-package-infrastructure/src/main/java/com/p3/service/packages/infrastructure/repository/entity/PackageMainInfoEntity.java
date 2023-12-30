package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 包裹信息主表
 * @TableName package_main_info
 */
@Data
@Accessors(chain = true)
@TableName(value ="package_main_info")
public class PackageMainInfoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5590735685789681282L;
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
     * 所属客户编号
     */
    @TableField(value = "customer_code")
    private String customerCode;

    /**
     * 所属客户等级
     */
    @TableField(value = "customer_rank")
    private String customerRank;

    /**
     * 所属客户名称
     */
    @TableField(value = "customer_name")
    private String customerName;

    /**
     * 第三方客户代号
     */
    @TableField(value = "third_party_code")
    private String thirdPartyCode;

    /**
     * 寄出仓库
     */
    @TableField(value = "shipping_warehouse")
    private String shippingWarehouse;

    /**
     * 寄往国家
     */
    @TableField(value = "destination_country")
    private String destinationCountry;

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

    /**
     * 货品价值
     */
    @TableField(value = "goods_value")
    private BigDecimal goodsValue;

    /**
     * 集包标识
     */
    @TableField(value = "composited")
    private Boolean composited;

    /**
     * 运输方式
     */
    @TableField(value = "shipping_method")
    private String shippingMethod;

}