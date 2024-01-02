package com.p3.service.packages.domain.model.mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PackageServiceItemMapper<T> {

    T map(String id, String serviceType, String serviceName, BigDecimal fee, Integer activated, LocalDateTime creationTime);
}
