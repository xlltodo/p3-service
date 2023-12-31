package com.p3.service.packages.domain.model.entity;

import lombok.Getter;

@Getter
public enum PackageTrackingNumberTypeEnum {

    PACKAGE_CODE("PACKAGE_CODE", "", 0, "包裹系统编号"),
    CX_NUMBER("CX_NUMBER", "CX", 12, "包裹单号"),
    EXPRESS_NUMBER("EXPRESS_NUMBER", "", 0, "快递单号"),
    COMPOSITE_PACKAGE_NUMBER("COMPOSITE_PACKAGE_NUMBER", "CJM", 12, "集包单号"),
    T_OUT_NUMBER("T_OUT_NUMBER", "TOUT", 12, "出库单号单号");

    private final String code;
    private final String prefix;
    private final Integer length;
    private final String describe;

    PackageTrackingNumberTypeEnum(String code, String prefix, Integer length, String describe) {
        this.code = code;
        this.prefix = prefix;
        this.length = length;
        this.describe = describe;
    }
}
