package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;

import java.time.LocalDateTime;

public class PackageSpatialAttributeFactory {

    public static PackageSpatialAttribute create(String id, String packageCode, Double length,
                                                 Double width, Double height, Double volume,
                                                 Double weight, LocalDateTime measurementTime) {
        return new PackageSpatialAttribute(id, packageCode, length, width, height, volume, weight, measurementTime);
    }
}
