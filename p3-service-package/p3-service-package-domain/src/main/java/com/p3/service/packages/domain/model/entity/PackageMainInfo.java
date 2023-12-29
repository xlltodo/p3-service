package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import com.p3.service.packages.domain.model.mapper.PackageMainInfoMapper;
import lombok.Data;

public class PackageMainInfo {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 包裹编号
     */
    private String packageCode;

    /**
     * 所属客户编号
     */
    private String customerCode;

    /**
     * 所属客户等级
     */
    private String customerRank;

    /**
     * 所属客户名称
     */
    private String customerName;

    /**
     * 第三方客户代号
     */
    private String thirdPartyCode;

    /**
     * 寄出仓库
     */
    private String shippingWarehouse;

    /**
     * 寄往国家
     */
    private String destinationCountry;

    /**
     * 一级货品类型
     */
    private String primaryGoodsType;

    /**
     * 二级货品类型
     */
    private String secondaryGoodsType;

    /**
     * 货品价值
     */
    private BigDecimal goodsValue;

    /**
     * 集包标识
     */
    private Integer composited;

    /**
     * 运输方式
     */
    private String shippingMethod;

    public PackageMainInfo(String id, String packageCode, String customerCode, String customerRank, String customerName, String thirdPartyCode, String shippingWarehouse, String destinationCountry, String primaryGoodsType, String secondaryGoodsType, BigDecimal goodsValue, Integer composited, String shippingMethod) {
        this.id = id;
        this.packageCode = packageCode;
        this.customerCode = customerCode;
        this.customerRank = customerRank;
        this.customerName = customerName;
        this.thirdPartyCode = thirdPartyCode;
        this.shippingWarehouse = shippingWarehouse;
        this.destinationCountry = destinationCountry;
        this.primaryGoodsType = primaryGoodsType;
        this.secondaryGoodsType = secondaryGoodsType;
        this.goodsValue = goodsValue;
        this.composited = composited;
        this.shippingMethod = shippingMethod;
    }

    public <T> T mapWith(PackageMainInfoMapper<T> mapper) {
        return mapper.map(this.id, this.packageCode, this.customerCode, this.customerRank,
                this.customerName, this.thirdPartyCode, this.shippingWarehouse,
                this.destinationCountry, this.primaryGoodsType, this.secondaryGoodsType,
                this.goodsValue, this.composited, this.shippingMethod);
    }
}