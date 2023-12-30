package com.p3.service.packages.application.result;

import com.p3.service.packages.application.command.QualityControlSheetServiceCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class QualityControlSheetResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 6603277457469332796L;

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "快递单号")
    private String expressBillNumber;

    @Schema(description = "质检单包裹信息")
    private List<QualityControlSheetPackageResult> packages;

    @Schema(description = "质检单服务信息")
    private List<QualityControlSheetServiceCommand> services;

    @Schema(description = "客户代号")
    private String customerCode;

    @Schema(description = "客户昵称")
    private String customerNickname;

    @Schema(description = "客户等级")
    private String customerLevel;

    @Schema(description = "客户类型")
    private String customerType;

    @Schema(description = "第三方客户代号")
    private String thirdPartyCustomerCode;

    @Schema(description = "第三方客户等级")
    private String thirdPartyCustomerLevel;

    @Schema(description = "存放库位")
    private String storageLocation;

    @Schema(description = "应收包裹件数")
    private Integer expectedPackageCount;

    @Schema(description = "实收包裹件数")
    private Integer actualPackageCount;

    @Schema(description = "应收商品数量")
    private Integer expectedProductCount;

    @Schema(description = "实收商品数量")
    private Integer actualProductCount;

    @Schema(description = "商品总价值")
    private BigDecimal totalProductValue;

    @Schema(description = "仓库编号")
    private String warehouseCode;

    @Schema(description = "仓库名称")
    private String warehouseName;

    @Schema(description = "寄往地区编号")
    private String destinationRegionCode;

    @Schema(description = "寄往地区名称")
    private String destinationRegionName;

    @Schema(description = "快递公司编号")
    private String expressCompanyCode;

    @Schema(description = "快递公司名称")
    private String expressCompanyName;

    @Schema(description = "异常件标识（0否1是）")
    private Boolean exceptional;

    @Schema(description = "商品列表")
    List<QualityControlSheetGoodsInfoResult> goods;

    @Schema(description = "原始商品备注")
    private String originalProductRemarks;

    @Schema(description = "包裹状态（预留字段）")
    private String packageStatus;

    @Schema(description = "质检员ID")
    private String inspectorId;

    @Schema(description = "质检员名称")
    private String inspectorName;

    @Schema(description = "质检时间")
    private LocalDateTime inspectionTime;
}
