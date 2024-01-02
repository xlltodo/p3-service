package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.PackageGoodsInfoMapper;

import java.math.BigDecimal;

public class PackageGoodsInfo {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 包裹编号
     */
    private String packageCode;

    /**
     * 品名
     */
    private String productName;

    /**
     * 货品名称
     */
    private String goodsName;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 规格
     */
    private String specification;

    /**
     * 发货数量
     */
    private Integer shipmentQuantity;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 货品图片
     */
    private String imageUrl;

    public PackageGoodsInfo(String id, String packageCode, String productName, String goodsName, String goodsType, String specification, Integer shipmentQuantity, BigDecimal unitPrice, BigDecimal totalPrice, String imageUrl) {
        this.id = id;
        this.packageCode = packageCode;
        this.productName = productName;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.specification = specification;
        this.shipmentQuantity = shipmentQuantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.imageUrl = imageUrl;
    }

    public <T> T mapWith(PackageGoodsInfoMapper<T> mapper) {
        return mapper.map(this.id, this.packageCode, this.productName, this.goodsName, this.goodsType,
                this.specification, this.shipmentQuantity, this.unitPrice, this.totalPrice, this.imageUrl);
    }

}