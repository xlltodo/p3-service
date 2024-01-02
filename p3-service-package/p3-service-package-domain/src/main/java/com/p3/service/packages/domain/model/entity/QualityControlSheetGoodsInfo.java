package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.QualityControlSheetGoodsInfoMapper;

import java.math.BigDecimal;

public class QualityControlSheetGoodsInfo {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 质检单ID
     */
    private String sheetId;

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
     * 二级货品类型
     */
    private String imageUrl;

    public QualityControlSheetGoodsInfo(String id, String sheetId, String productName, String goodsName, String goodsType, String specification, Integer shipmentQuantity, BigDecimal unitPrice, BigDecimal totalPrice, String imageUrl) {
        this.id = id;
        this.sheetId = sheetId;
        this.productName = productName;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.specification = specification;
        this.shipmentQuantity = shipmentQuantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.imageUrl = imageUrl;
    }

    public <T> T mapWith(QualityControlSheetGoodsInfoMapper<T> mapper) {
        return mapper.map(this.id, this.sheetId, this.productName, this.goodsName, this.goodsType,
                this.specification, this.shipmentQuantity, this.unitPrice, this.totalPrice, this.imageUrl);
    }

}