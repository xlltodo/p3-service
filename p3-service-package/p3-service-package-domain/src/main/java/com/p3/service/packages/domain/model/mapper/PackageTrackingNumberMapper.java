package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;

import java.time.LocalDateTime;

public interface PackageTrackingNumberMapper<T> {

    T map(String id, String packageCode, PackageTrackingNumberTypeEnum numberType, String trackingNumber, LocalDateTime creationTime);
}
