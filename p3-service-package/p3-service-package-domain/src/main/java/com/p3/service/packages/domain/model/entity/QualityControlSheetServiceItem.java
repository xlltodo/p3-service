package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.event.QualityControlSheetSubmitDomainEvent;
import com.p3.service.packages.domain.model.mapper.QualityControlSheetServiceItemMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QualityControlSheetServiceItem {
    
    /**
     * 主键ID
     */
    private String id;

    /**
     * 质检单ID
     */
    private String sheetId;

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

    public QualityControlSheetServiceItem(String id, String sheetId, String serviceType, String serviceName, BigDecimal fee, Integer activated, LocalDateTime creationTime) {
        this.id = id;
        this.sheetId = sheetId;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.fee = fee;
        this.activated = activated;
        this.creationTime = creationTime;
    }

    public <T> T mapWith(QualityControlSheetServiceItemMapper<T> mapper) {
        return mapper.map(this.id, this.sheetId, this.serviceType, this.serviceName, this.fee, this.activated, this.creationTime);
    }

    public QualityControlSheetSubmitDomainEvent.Service submit() {
        return new QualityControlSheetSubmitDomainEvent.Service()
                .setServiceType(this.serviceType)
                .setServiceName(this.serviceName)
                .setFee(this.fee)
                .setActivated(this.activated);
    }

}