package com.p3.service.packages.domain.event;

import com.p3.service.packages.domain.event.base.SyncInProcessBaseDomainEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class QualityControlSheetSubmitDomainEvent extends SyncInProcessBaseDomainEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 6183070194191891837L;

    /**
     * 快递单号
     */
    private String expressBillNumber;

    /**
     * 质检单包裹信息
     */
    private List<Package> packages;

    /**
     * 质检单服务信息
     */
    private List<Service> services;

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
     * 原始商品备注
     */
    private String originalProductRemarks;

    public QualityControlSheetSubmitDomainEvent() {

        super("");
    }

    public QualityControlSheetSubmitDomainEvent(String expressBillNumber, List<Package> packages, String customerCode, String storageLocation, Integer expectedPackageCount, Integer actualPackageCount, Integer expectedProductCount, Integer actualProductCount, BigDecimal totalProductValue, String warehouseCode, String warehouseName, String destinationRegionCode, String destinationRegionName, String expressCompanyCode, String expressCompanyName, String packageStatus, String inspectorId, String inspectorName, LocalDateTime inspectionTime, String originalProductRemarks) {
        super("");
        this.expressBillNumber = expressBillNumber;
        this.packages = packages;
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
        this.originalProductRemarks = originalProductRemarks;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Package implements Serializable {

        @Serial
        private static final long serialVersionUID = 980385309004560767L;

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
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Service implements Serializable {

        @Serial
        private static final long serialVersionUID = -1608343334976418775L;

        /**
         * 服务类型
         */
        private String serviceType;

        /**
         * 服务名称
         */
        private String serviceName;

        /**
         * 服务费
         */
        private BigDecimal fee;

        /**
         * 已开通标识（0否1是）
         */
        private Integer activated;
    }
}
