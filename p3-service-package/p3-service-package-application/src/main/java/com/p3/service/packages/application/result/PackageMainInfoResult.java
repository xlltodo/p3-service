package com.p3.service.packages.application.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class PackageMainInfoResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -2798886255997352587L;
    
    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "包裹编号")
    private String packageCode;

    @Schema(description = "追踪单号")
    private List<PackageTrackingNumberResult> trackingNumber;

    @Schema(description = "空间属性")
    private List<PackageSpatialAttributesResult> spatialAttributes;

    @Schema(description = "服务信息")
    private List<PackageServiceItemResult> serviceItems;

    @Schema(description = "所属客户编号")
    private String customerCode;

    @Schema(description = "所属客户名称")
    private String customerNickname;

    @Schema(description = "所属客户等级")
    private String customerLevel;

    @Schema(description = "所属客户类型")
    private String customerType;

    @Schema(description = "第三方客户代号")
    private String thirdPartyCustomerCode;

    @Schema(description = "第三方客户等级")
    private String thirdPartyCustomerLevel;

    @Schema(description = "寄出仓库")
    private String shippingWarehouse;

    @Schema(description = "寄往国家")
    private String destinationCountry;

    @Schema(description = "一级货品类型")
    private String primaryGoodsType;

    @Schema(description = "二级货品类型")
    private String secondaryGoodsType;

    @Schema(description = "货品价值")
    private BigDecimal goodsValue;

    @Schema(description = "集包标识")
    private Boolean composited;

    @Schema(description = "运输方式")
    private String shippingMethod;

    @Schema(description = "包裹商品")
    private List<PackageGoodsInfoResult> goodsInfo;

}