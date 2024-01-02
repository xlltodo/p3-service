package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.event.QualityControlSheetSubmitDomainEvent;
import com.p3.service.packages.domain.model.mapper.QualityControlSheetPackageMapper;

public class QualityControlSheetPackage {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 质检单ID
     */
    private String sheetId;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 长
     */
    private Double length;

    /**
     * 宽
     */
    private Double width;

    /**
     * 高
     */
    private Double height;

    /**
     * 体积
     */
    private Double volume;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 品名
     */
    private String productName;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 一级货品类型
     */
    private String primaryGoodsType;

    /**
     * 二级货品类型
     */
    private String secondaryGoodsType;

    public QualityControlSheetPackage(String id, String sheetId, Double weight, Double length, Double width, Double height, Double volume, Integer quantity, String productName, String brandName, String primaryGoodsType, String secondaryGoodsType) {
        this.id = id;
        this.sheetId = sheetId;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
        this.quantity = quantity;
        this.productName = productName;
        this.brandName = brandName;
        this.primaryGoodsType = primaryGoodsType;
        this.secondaryGoodsType = secondaryGoodsType;
    }

    public <T> T mapWith(QualityControlSheetPackageMapper<T> mapper) {
        return mapper.map(this.id, this.sheetId, this.weight, this.length,
                this.width, this.height, this.volume, this.quantity,
                this.productName, this.brandName, this.primaryGoodsType,
                this.secondaryGoodsType);
    }

    public QualityControlSheetSubmitDomainEvent.Package submit() {
        return new QualityControlSheetSubmitDomainEvent.Package()
                .setWeight(weight)
                .setLength(length)
                .setWidth(width)
                .setHeight(height)
                .setVolume(volume)
                .setQuantity(quantity)
                .setProductName(productName)
                .setBrandName(brandName)
                .setPrimaryGoodsType(primaryGoodsType)
                .setSecondaryGoodsType(secondaryGoodsType);
    }
}