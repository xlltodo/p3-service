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
     * 运输方式CODE
     */
    private String transportMethodCode;

    /**
     * 运输方式名称
     */
    private String transportMethodName;

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
     * 质检时间
     */
    private List<Goods> goods;

    /**
     * 原始商品备注
     */
    private String originalProductRemarks;

    public QualityControlSheetSubmitDomainEvent() {

        super("");
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

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Goods implements Serializable {

        @Serial
        private static final long serialVersionUID = -5941047123114253352L;

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
    }

}
