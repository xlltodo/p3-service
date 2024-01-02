package com.p3.service.packages.application.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class QualityControlSheetServiceResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 4299225472943355875L;

    /**
     * 服务类型
     */
    private String serviceType;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务费
     */
    private BigDecimal fee;

    /**
     * 已开通标识（0否1是）
     */
    private Integer activated;

    /**
     * 创建时间
     */
    private LocalDateTime creationTime;

}
