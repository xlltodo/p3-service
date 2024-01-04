package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.CompositePackageMainInfoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompositePackageMainInfo {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 集包编号
     */
    private String compositePackageCode;

    /**
     * 集包方式
     */
    private String compositeMethod;

    /**
     * 集包数量
     */
    private Integer compositeQuantity;

    /**
     * 集包包装类型
     */
    private String compositePackagingType;

    /**
     * 运输方式
     */
    private String transportMethod;

    /**
     * 一级货品类型
     */
    private String primaryGoodsType;

    /**
     * 二级货品类型
     */
    private String secondaryGoodsType;

    /**
     * 空间属性
     */
    private List<CompositePackageTrackingNumber> trackingNumbers;

    /**
     * 空间属性
     */
    private List<CompositePackageSpatialAttribute> spatialAttributes;

    /**
     * 关联包裹
     */
    private List<CompositePackageAssociation> packageAssociations;

    public CompositePackageMainInfo(String id, String compositePackageCode, String compositeMethod, Integer compositeQuantity, String compositePackagingType, String transportMethod, String primaryGoodsType, String secondaryGoodsType, List<CompositePackageTrackingNumber> trackingNumbers, List<CompositePackageSpatialAttribute> spatialAttributes, List<CompositePackageAssociation> packageAssociations) {
        this.id = id;
        this.compositePackageCode = compositePackageCode;
        this.compositeMethod = compositeMethod;
        this.compositeQuantity = compositeQuantity;
        this.compositePackagingType = compositePackagingType;
        this.transportMethod = transportMethod;
        this.primaryGoodsType = primaryGoodsType;
        this.secondaryGoodsType = secondaryGoodsType;
        this.trackingNumbers = Optional.ofNullable(trackingNumbers).orElse(new ArrayList<>());
        this.spatialAttributes = spatialAttributes;
        this.packageAssociations = packageAssociations;
    }

    public <T> T mapWith(CompositePackageMainInfoMapper<T> mapper) {
        return mapper.map(this.id, this.compositePackageCode, this.compositeMethod, this.compositeQuantity, this.compositePackagingType, this.transportMethod, this.primaryGoodsType, this.secondaryGoodsType, this.packageAssociations);
    }

    public String addTrackingNumber(CompositePackageTrackingNumber trackingNumber) {
        this.trackingNumbers.add(trackingNumber);
        return trackingNumber.getTrackingNumber();
    }

    public String getCompositePackageCode() {
        return this.compositePackageCode;
    }

    public List<CompositePackageTrackingNumber> getTrackingNumbers() {
        return this.trackingNumbers;
    }

    public List<CompositePackageSpatialAttribute> getSpatialAttributes() {
        return this.spatialAttributes;
    }

    public List<CompositePackageAssociation> getPackageAssociations() {
        return this.packageAssociations;
    }
}