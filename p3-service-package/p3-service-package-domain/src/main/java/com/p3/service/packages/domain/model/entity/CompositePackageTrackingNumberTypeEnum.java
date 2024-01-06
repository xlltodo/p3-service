package com.p3.service.packages.domain.model.entity;

import lombok.Getter;

@Getter
public enum CompositePackageTrackingNumberTypeEnum {

    COMPOSITE_PACKAGE_CODE("COMPOSITE_PACKAGE_CODE", "", 0, "集包系统编号"),
    CJM_NUMBER("CJM_NUMBER", "CJM", 12, "集包单号"),
    T_OUT_NUMBER("T_OUT_NUMBER", "TOUT", 12, "出库单号单号");

    private final String code;
    private final String prefix;
    private final Integer length;
    private final String describe;

    CompositePackageTrackingNumberTypeEnum(String code, String prefix, Integer length, String describe) {
        this.code = code;
        this.prefix = prefix;
        this.length = length;
        this.describe = describe;
    }
}
