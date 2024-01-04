package com.p3.service.packages.domain.model.mapper;

import java.time.LocalDateTime;

public interface CompositePackageSpatialAttributeMapper<T> {

    T map(String id, String compositePackageCode, Double length, Double width, Double height, Double volume, Double weight, LocalDateTime measurementTime);
}
