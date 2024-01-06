package com.p3.service.packages.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CompositePackageCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = -2202851153206492142L;

    @Schema(description = "集包方式（一包一集：ONE_PACKAGE、多包一集：MULTIPLE_PACKAGES）")
    private String compositeMethod;

    @Schema(description = "集包包装类型")
    private String compositePackagingType;

    @Schema(description = "重量")
    private Double weight;

    @Schema(description = "体积")
    private Double volume;

    @Schema(description = "长")
    private Double length;

    @Schema(description = "宽")
    private Double width;

    @Schema(description = "高")
    private Double height;

    @Schema(description = "一级货品类型")
    private String primaryGoodsType;

    @Schema(description = "二级货品类型")
    private String secondaryGoodsType;

    @Schema(description = "集包标识")
    private Boolean composited;

    @Schema(description = "运输方式CODE")
    private String transportMethodCode;

    @Schema(description = "运输方式名称")
    private String transportMethodName;

    @Schema(description = "箱子集合（包裹编号packageCode，不是cx编号）")
    private List<String> packageCodes;
}
