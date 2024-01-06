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
@TableName(value ="package_main_info")
@Data
@Accessors(chain = true)
public class PackageMainInfoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7589681577302802781L;

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
     * 所属客户名称
     */
    @TableField(value = "customer_nickname")
    private String customerNickname;

    /**
     * 所属客户等级
     */
    @TableField(value = "customer_level")
    private String customerLevel;

    /**
     * 所属客户类型
     */
    @TableField(value = "customer_type")
    private String customerType;

    /**
     * 第三方客户代号
     */
    @TableField(value = "third_party_customer_code")
    private String thirdPartyCustomerCode;

    /**
     * 第三方客户等级
     */
    @TableField(value = "third_party_customer_level")
    private String thirdPartyCustomerLevel;

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
     * 运输方式
     */
    @TableField(value = "transport_method_code")
    private String transportMethodCode;

    /**
     * 运输方式
     */
    @TableField(value = "transport_method_name")
    private String transportMethodName;

    /**
     * 包裹状态
     */
    @TableField(value = "package_status")
    private String packageStatus;

    /**
     * 集包标识
     */
    @TableField(value = "composited")
    private Boolean composited;

}