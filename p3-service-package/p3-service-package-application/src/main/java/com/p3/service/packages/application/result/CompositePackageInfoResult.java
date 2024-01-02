package com.p3.service.packages.application.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CompositePackageInfoResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 5228697992237268889L;

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "包裹编号")
    private String packageCode;

    @Schema(description = "所属客户编号")
    private String customerCode;

    @Schema(description = "所属客户名称")
    private String customerNickname;

    @Schema(description = "所属客户等级")
    private String customerLevel;

    @Schema(description = "第三方客户代号")
    private String thirdPartyCustomerCode;

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
    private Integer composited;

    @Schema(description = "运输方式")
    private String shippingMethod;
}
