package com.p3.service.packages.domain.model.entity;

import lombok.Getter;

@Getter
public enum PackageTrackingNumberTypeEnum {

    CX_NUMBER("CX_NUMBER", "CX", "包裹单号"),
    EXPRESS_NUMBER("EXPRESS_NUMBER", "", "快递单号"),
    COMPOSITE_PACKAGE_NUMBER("COMPOSITE_PACKAGE_NUMBER", "", "集包单号");

    private final String code;
    private final String prefix;
    private final String describe;

    PackageTrackingNumberTypeEnum(String code, String prefix, String describe) {
        this.code = code;
        this.prefix = prefix;
        this.describe = describe;
    }
}
