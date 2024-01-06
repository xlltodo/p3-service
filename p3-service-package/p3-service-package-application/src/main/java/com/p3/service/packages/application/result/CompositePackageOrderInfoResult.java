package com.p3.service.packages.application.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CompositePackageOrderInfoResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -9058138213013158483L;

    @Schema(description = "CJM单号")
    private String cjmNumber;

    @Schema(description = "操作人名称")
    private String operatorName;

    @Schema(description = "运输方式CODE")
    private String transportMethodCode;

    @Schema(description = "一级货品类型")
    private String primaryGoodsType;

    @Schema(description = "二级货品类型")
    private String secondaryGoodsType;
}
