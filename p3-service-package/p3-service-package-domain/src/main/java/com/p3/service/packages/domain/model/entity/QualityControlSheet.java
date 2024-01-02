package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.event.QualityControlSheetSubmitDomainEvent;
import com.p3.service.packages.domain.model.mapper.QualityControlSheetMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class QualityControlSheet {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 快递单号
     */
    private String expressBillNumber;

    /**
     * 质检单包裹信息
     */
    private List<QualityControlSheetPackage> packages;

    /**
     * 质检单服务信息
     */
    private List<QualityControlSheetServiceItem> services;

    /**
     * 客户编号
     */
    private String customerCode;

    /**
     * 存放库位
     */
    private String storageLocation;

    /**
     * 应收包裹件数
     */
    private Integer expectedPackageCount;

    /**
     * 实收包裹件数
     */
    private Integer actualPackageCount;

    /**
     * 应收商品数量
     */
    private Integer expectedProductCount;

    /**
     * 实收商品数量
     */
    private Integer actualProductCount;

    /**
     * 商品总价值
     */
    private BigDecimal totalProductValue;

    /**
     * 仓库编号
     */
    private String warehouseCode;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 寄往地区编号
     */
    private String destinationRegionCode;

    /**
     * 寄往地区名称
     */
    private String destinationRegionName;

    /**
     * 快递公司编号
     */
    private String expressCompanyCode;

    /**
     * 快递公司名称
     */
    private String expressCompanyName;

    /**
     * 包裹状态
     */
    private String packageStatus;

    /**
     * 质检员ID
     */
    private String inspectorId;

    /**
     * 质检员名称
     */
    private String inspectorName;

    /**
     * 质检时间
     */
    private LocalDateTime inspectionTime;

    /**
     * 商品
     */
    private List<QualityControlSheetGoodsInfo> goodsInfos;

    /**
     * 原始商品备注
     */
    private String originalProductRemarks;

    public QualityControlSheet(String id, String expressBillNumber, List<QualityControlSheetPackage> packages, List<QualityControlSheetServiceItem> services, String customerCode, String storageLocation, Integer expectedPackageCount, Integer actualPackageCount, Integer expectedProductCount, Integer actualProductCount, BigDecimal totalProductValue, String warehouseCode, String warehouseName, String destinationRegionCode, String destinationRegionName, String expressCompanyCode, String expressCompanyName, String packageStatus, String inspectorId, String inspectorName, LocalDateTime inspectionTime, List<QualityControlSheetGoodsInfo> goodsInfos, String originalProductRemarks) {
        this.id = id;
        this.expressBillNumber = expressBillNumber;
        this.packages = packages;
        this.services = services;
        this.customerCode = customerCode;
        this.storageLocation = storageLocation;
        this.expectedPackageCount = expectedPackageCount;
        this.actualPackageCount = actualPackageCount;
        this.expectedProductCount = expectedProductCount;
        this.actualProductCount = actualProductCount;
        this.totalProductValue = totalProductValue;
        this.warehouseCode = warehouseCode;
        this.warehouseName = warehouseName;
        this.destinationRegionCode = destinationRegionCode;
        this.destinationRegionName = destinationRegionName;
        this.expressCompanyCode = expressCompanyCode;
        this.expressCompanyName = expressCompanyName;
        this.packageStatus = packageStatus;
        this.inspectorId = inspectorId;
        this.inspectorName = inspectorName;
        this.inspectionTime = inspectionTime;
        this.goodsInfos = goodsInfos;
        this.originalProductRemarks = originalProductRemarks;
    }

    public <T> T mapWith(QualityControlSheetMapper<T> mapper) {
        return mapper.map(this.id, this.expressBillNumber, this.packages, this.services, this.customerCode, this.storageLocation,
                this.expectedPackageCount, this.actualPackageCount, this.expectedProductCount,
                this.actualProductCount, this.totalProductValue, this.warehouseCode,
                this.warehouseName, this.destinationRegionCode, this.destinationRegionName,
                this.expressCompanyCode, this.expressCompanyName, this.packageStatus,
                this.inspectorId, this.inspectorName, this.inspectionTime, this.originalProductRemarks);
    }

    public String getUniqueIdentifier() {
        return this.id;
    }

    public String getExpressBillNumber() {
        return this.expressBillNumber;
    }

    public List<QualityControlSheetPackage> getPackages() {
        return this.packages;
    }
    public List<QualityControlSheetServiceItem> getServices() {
        return this.services;
    }
    public List<QualityControlSheetGoodsInfo> getGoodsInfos() {
        return this.goodsInfos;
    }

    public QualityControlSheetSubmitDomainEvent submit() {

        return new QualityControlSheetSubmitDomainEvent()
                .setExpressBillNumber(this.expressBillNumber)
                .setPackages(this.packages.stream().map(QualityControlSheetPackage::submit).collect(Collectors.toList()))
                .setServices(this.services.stream().map(QualityControlSheetServiceItem::submit).collect(Collectors.toList()))
                .setCustomerCode(this.customerCode)
                .setStorageLocation(this.storageLocation)
                .setExpectedPackageCount(this.expectedPackageCount)
                .setActualPackageCount(this.actualPackageCount)
                .setExpectedProductCount(this.expectedProductCount)
                .setActualProductCount(this.actualProductCount)
                .setTotalProductValue(this.totalProductValue)
                .setWarehouseCode(this.warehouseCode)
                .setWarehouseName(this.warehouseName)
                .setDestinationRegionCode(this.destinationRegionCode)
                .setDestinationRegionName(this.destinationRegionName)
                .setExpressCompanyCode(this.expressCompanyCode)
                .setExpressCompanyName(this.expressCompanyName)
                .setPackageStatus(this.packageStatus)
                .setInspectorId(this.inspectorId)
                .setInspectorName(this.inspectorName)
                .setInspectionTime(this.inspectionTime)
                .setOriginalProductRemarks(this.originalProductRemarks);
    }

    public void submitQualityControlSheet(String inspectorId, String inspectorName) {

        this.inspectorId = inspectorId;
        this.inspectorName = inspectorName;
        this.inspectionTime = LocalDateTime.now();
    }

}