package com.p3.service.packages.domain.model.mapper;

import java.time.LocalDateTime;

@FunctionalInterface
public interface PackageSpatialAttributeMapper<T> {

    T map(String id, String packageCode, Double length, Double width, Double height, Double volume, Double weight, LocalDateTime measurementTime);
}
