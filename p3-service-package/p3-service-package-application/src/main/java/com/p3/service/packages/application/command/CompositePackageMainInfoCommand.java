package com.p3.service.packages.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CompositePackageMainInfoCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = -2202851153206492142L;

    @Schema(description = "集包方式（一包一集：ONE_PACKAGE、多包一集：MULTIPLE_PACKAGES）")
    private String packagingMethod;

    @Schema(description = "集包类型")
    private String packagingType;

    @Schema(description = "集包重量")
    private double weight;

    @Schema(description = "长")
    private double length;

    @Schema(description = "宽")
    private double width;

    @Schema(description = "高")
    private double height;

    @Schema(description = "一级货品类型")
    private String primaryGoodsType;

    @Schema(description = "二级货品类型")
    private String secondaryGoodsType;

    @Schema(description = "集包标识")
    private Boolean composited;

    @Schema(description = "运输方式")
    private String shippingMethod;

    @Schema(description = "箱子集合（CX号 箱子编号）")
    private List<String> boxes;
}
