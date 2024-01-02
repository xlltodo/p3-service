package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.PackageMainInfoMapper;

import java.math.BigDecimal;
import java.util.List;

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
     * 单号
     */
    List<PackageTrackingNumber> trackingNumbers;

    /**
     * 空间属性
     */
    List<PackageSpatialAttribute> spatialAttributes;

    /**
     * 服务
     */
    List<PackageServiceItem> serviceItems;

    /**
     * 所属客户编号
     */
    private String customerCode;

    /**
     * 所属客户名称
     */
    private String customerNickname;

    /**
     * 所属客户等级
     */
    private String customerLevel;

    /**
     * 所属客户类型
     */
    private String customerType;

    /**
     * 第三方客户代号
     */
    private String thirdPartyCustomerCode;

    /**
     * 第三方客户等级
     */
    private String thirdPartyCustomerLevel;

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
    private Boolean composited;

    /**
     * 运输方式
     */
    private String shippingMethod;

    /**
     * 商品信息
     */
    private List<PackageGoodsInfo> goodsInfos;

    public PackageMainInfo(String id, String packageCode, List<PackageTrackingNumber> trackingNumbers, List<PackageSpatialAttribute> spatialAttributes, List<PackageServiceItem> serviceItems, String customerCode, String customerNickname, String customerLevel, String customerType, String thirdPartyCustomerCode, String thirdPartyCustomerLevel, String shippingWarehouse, String destinationCountry, String primaryGoodsType, String secondaryGoodsType, BigDecimal goodsValue, Boolean composited, String shippingMethod) {
        this.id = id;
        this.packageCode = packageCode;
        this.trackingNumbers = trackingNumbers;
        this.spatialAttributes = spatialAttributes;
        this.serviceItems = serviceItems;
        this.customerCode = customerCode;
        this.customerNickname = customerNickname;
        this.customerLevel = customerLevel;
        this.customerType = customerType;
        this.thirdPartyCustomerCode = thirdPartyCustomerCode;
        this.thirdPartyCustomerLevel = thirdPartyCustomerLevel;
        this.shippingWarehouse = shippingWarehouse;
        this.destinationCountry = destinationCountry;
        this.primaryGoodsType = primaryGoodsType;
        this.secondaryGoodsType = secondaryGoodsType;
        this.goodsValue = goodsValue;
        this.composited = composited;
        this.shippingMethod = shippingMethod;
    }

    public <T> T mapWith(PackageMainInfoMapper<T> mapper) {
        return mapper.map(this.id, this.packageCode, this.trackingNumbers, this.spatialAttributes, this.serviceItems,
                this.customerCode, this.customerNickname, this.customerLevel, this.customerType,
                this.thirdPartyCustomerCode, this.thirdPartyCustomerLevel, this.shippingWarehouse, this.destinationCountry,
                this.primaryGoodsType, this.secondaryGoodsType, this.goodsValue,
                this.composited, this.shippingMethod);
    }

}