package com.p3.service.packages.domain.model.mapper;

import java.time.LocalDateTime;

public interface PackageTrackingNumberMapper<T> {

    T map(String id, String packageCode, String numberType, String trackingNumber, LocalDateTime creationTime);
}
