package com.p3.service.packages.domain.model.mapper;

import java.time.LocalDateTime;

public interface CompositePackageTrackingNumberMapper<T> {

    T map(String id, String compositePackageCode, String numberType, String trackingNumber, LocalDateTime creationTime);
}
