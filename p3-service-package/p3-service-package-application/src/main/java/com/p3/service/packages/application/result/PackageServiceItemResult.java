package com.p3.service.packages.application.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PackageServiceItemResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -6847189194471057261L;

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "包裹编号")
    private String packageCode;

    @Schema(description = "服务类型")
    private String serviceType;

    @Schema(description = "服务名称")
    private String serviceName;

    @Schema(description = "服务费")
    private BigDecimal fee;

    @Schema(description = "已开通标识（0否1是）")
    private Integer activated;

    @Schema(description = "创建时间")
    private LocalDateTime creationTime;

}