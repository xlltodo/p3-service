package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;

import java.time.LocalDateTime;

public class PackageTrackingNumberFactory {

    public static PackageTrackingNumber create(String id, String packageCode, String numberType,
                                               String trackingNumber, LocalDateTime creationTime) {
        return new PackageTrackingNumber(id, packageCode, numberType, trackingNumber, creationTime);
    }
}
