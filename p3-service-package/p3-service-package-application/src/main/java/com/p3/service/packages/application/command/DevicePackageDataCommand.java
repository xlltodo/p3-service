package com.p3.service.packages.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DevicePackageDataCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = -174750322956158975L;

    @NotBlank(message = "单号不能为空")
    @Schema(description = "单号(包裹条码)")
    private String ticketsNum;

    @PositiveOrZero(message = "重量必须为正数")
    @Schema(description = "重量(KG)")
    private double weight;

    @PositiveOrZero(message = "长度必须为正数")
    @Schema(description = "长度(mm)")
    private double length;

    @PositiveOrZero(message = "宽度必须为正数")
    @Schema(description = "宽度(mm)")
    private double width;

    @PositiveOrZero(message = "高度必须为正数")
    @Schema(description = "高度(mm)")
    private double height;

    @PositiveOrZero(message = "体积必须为正数")
    @Schema(description = "体积 (立方毫米)")
    private double volume;

    @NotBlank(message = "设备名称不能为空")
    @Schema(description = "设备名称")
    private String machine;
}
