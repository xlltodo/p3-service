package com.p3.service.packages.application.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PackageQualityControlSheetQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 6884650230434569085L;

    @NotBlank(message = "快递单号不能为空")
    @Schema(description = "快递单号(包裹条码)")
    private String expressBillNumber;
}
