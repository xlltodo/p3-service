package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumber;

import java.time.LocalDateTime;

public class CompositePackageTrackingNumberFactory {

    public static CompositePackageTrackingNumber create(String id, String compositePackageCode, String numberType, String trackingNumber, LocalDateTime creationTime) {
        return new CompositePackageTrackingNumber(id, compositePackageCode, numberType, trackingNumber, creationTime);
    }
}
