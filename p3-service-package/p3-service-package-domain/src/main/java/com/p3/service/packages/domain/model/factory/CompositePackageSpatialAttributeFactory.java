package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.CompositePackageSpatialAttribute;

import java.time.LocalDateTime;

public class CompositePackageSpatialAttributeFactory {

    public static CompositePackageSpatialAttribute create(String id, String compositePackageCode, Double length, Double width, Double height, Double volume, Double weight, LocalDateTime measurementTime) {
        return new CompositePackageSpatialAttribute(id, compositePackageCode, length, width, height, volume, weight, measurementTime);
    }
}
