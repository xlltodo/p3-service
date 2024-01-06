package com.p3.service.packages.domain.model.entity;

import lombok.Getter;

@Getter
public enum PackageStatusEnum {

    ORIGIN_WAREHOUSE_RECEIVED("ORIGIN_WAREHOUSE_RECEIVED", "始发仓已入库"),
    ORIGIN_WAREHOUSE_PENDING("ORIGIN_WAREHOUSE_PENDING", "始发仓待发货"),
    ORIGIN_WAREHOUSE_SHIPPED("ORIGIN_WAREHOUSE_SHIPPED", "始发仓已发货"),
    IN_TRANSIT_INTERNATIONAL("IN_TRANSIT_INTERNATIONAL", "国际运输中"),
    DESTINATION_WAREHOUSE_RECEIVED("DESTINATION_WAREHOUSE_RECEIVED", "目的仓已入库"),
    DESTINATION_WAREHOUSE_PENDING("DESTINATION_WAREHOUSE_PENDING", "目的仓待出库"),
    DESTINATION_WAREHOUSE_READY("DESTINATION_WAREHOUSE_READY", "目的仓待发货"),
    OUT_FOR_DELIVERY("OUT_FOR_DELIVERY", "待派送"),
    DELIVERING("DELIVERING", "派送中"),
    DELIVERED("DELIVERED", "已签收");

    private final String code;
    private final String description;

    PackageStatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
