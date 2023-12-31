package com.p3.service.packages.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class QualityControlSheetServiceCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 4299225472943355875L;

    @NotEmpty(message = "服务类型不能为空")
    @Schema(description = "服务类型信息")
    private String serviceType;

    @NotEmpty(message = "服务名称不能为空")
    @Schema(description = "服务名称信息")
    private String serviceName;

    @NotEmpty(message = "服务费不能为空")
    @Schema(description = "服务费")
    private BigDecimal fee;

    @NotEmpty(message = "已开通标识不能为空")
    @Schema(description = "已开通标识")
    private Integer activated;

}
