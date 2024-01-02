package com.p3.service.packages.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class QualityControlSheetPackageCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = -8482952137684761397L;

    @Schema(description = "质检单ID")
    private String sheetId;

    @Schema(description = "重量")
    private Double weight;

    @Schema(description = "长")
    private Double length;

    @Schema(description = "宽")
    private Double width;

    @Schema(description = "高")
    private Double height;

    @Schema(description = "体积")
    private Double volume;

    @Schema(description = "数量")
    private Integer quantity;

    @Schema(description = "品名")
    private String productName;

    @Schema(description = "品牌名称")
    private String brandName;

    @Schema(description = "一级货品类型")
    private String primaryGoodsType;

    @Schema(description = "二级货品类型")
    private String secondaryGoodsType;
}
