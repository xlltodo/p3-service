package com.p3.service.packages.application.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class QualityControlSheetGoodsInfoResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 7917889138465016816L;

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "包裹编号")
    private String packageCode;

    @Schema(description = "品名")
    private String productName;

    @Schema(description = "货品名称")
    private String goodsName;

    @Schema(description = "货物类型")
    private String goodsType;

    @Schema(description = "规格")
    private String specification;

    @Schema(description = "发货数量")
    private Integer shipmentQuantity;

    @Schema(description = "单价")
    private BigDecimal unitPrice;

    @Schema(description = "总价")
    private BigDecimal totalPrice;

    @Schema(description = "二级货品类型")
    private String imageUrl;

}