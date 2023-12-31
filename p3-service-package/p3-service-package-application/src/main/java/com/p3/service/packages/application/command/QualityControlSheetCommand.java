package com.p3.service.packages.application.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class QualityControlSheetCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 5435426654490902387L;

    @Schema(description = "主键ID")
    private String id;

    @NotBlank(message = "快递单号不能为空")
    @Schema(description = "快递单号")
    private String expressBillNumber;

    @NotEmpty(message = "质检单包裹信息不能为空")
    @Schema(description = "质检单包裹信息")
    private List<QualityControlSheetPackageCommand> packages;

    @NotEmpty(message = "质检单服务信息不能为空")
    @Schema(description = "质检单服务信息")
    private List<QualityControlSheetServiceCommand> services;

    @NotBlank(message = "客户编号不能为空")
    @Schema(description = "客户编号")
    private String customerCode;

    @NotBlank(message = "存放库位不能为空")
    @Schema(description = "存放库位")
    private String storageLocation;

    @NotNull(message = "实收包裹件数不能为空")
    @Min(value = 0, message = "实收包裹件数不能小于0")
    @Schema(description = "实收包裹件数")
    private Integer actualPackageCount;

    @NotNull(message = "实收商品数量不能为空")
    @Min(value = 0, message = "实收商品数量不能小于0")
    @Schema(description = "实收商品数量")
    private Integer actualProductCount;

    @NotNull(message = "商品总价值不能为空")
    @DecimalMin(value = "0.0", message = "商品总价值不能为负数")
    @Schema(description = "商品总价值")
    private BigDecimal totalProductValue;

    @NotBlank(message = "仓库编号不能为空")
    @Schema(description = "仓库编号")
    private String warehouseCode;

    @NotBlank(message = "仓库名称不能为空")
    @Schema(description = "仓库名称")
    private String warehouseName;

    @NotBlank(message = "寄往地区编号不能为空")
    @Schema(description = "寄往地区编号")
    private String destinationRegionCode;

    @NotBlank(message = "寄往地区名称不能为空")
    @Schema(description = "寄往地区名称")
    private String destinationRegionName;

    @NotBlank(message = "快递公司编号不能为空")
    @Schema(description = "快递公司编号")
    private String expressCompanyCode;

    @NotBlank(message = "快递公司名称不能为空")
    @Schema(description = "快递公司名称")
    private String expressCompanyName;
}