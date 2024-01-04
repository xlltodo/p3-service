package com.p3.service.packages.application.command;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PackageAddTrackingNumberCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 2925952360177897516L;

    @NotEmpty(message = "cxNumber不能为空")
    @Schema(description = "cxNumber")
    private String cxNumber;

    @NotEmpty(message = "单号类型不能为空")
    @Schema(description = "单号类型")
    private PackageTrackingNumberTypeEnum numberType;

    @NotBlank(message = "单号不能为空")
    @Schema(description = "单号")
    private String trackingNumber;

}