package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.p3.service.packages.domain.model.mapper.PackageServiceItemMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PackageServiceItem {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 包裹编号
     */
    private String packageCode;

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

    public PackageServiceItem(String id, String packageCode, String serviceType, String serviceName, BigDecimal fee, Integer activated, LocalDateTime creationTime) {
        this.id = id;
        this.packageCode = packageCode;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.fee = fee;
        this.activated = activated;
        this.creationTime = creationTime;
    }

    public <T> T mapWith(PackageServiceItemMapper<T> mapper) {
        return mapper.map(this.id, this.serviceType, this.serviceName, this.fee, this.activated, this.creationTime);
    }

}