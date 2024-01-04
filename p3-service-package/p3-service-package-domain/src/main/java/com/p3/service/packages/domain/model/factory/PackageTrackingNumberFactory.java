package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;

import java.time.LocalDateTime;

public class PackageTrackingNumberFactory {

    public static PackageTrackingNumber create(String id, String packageCode, PackageTrackingNumberTypeEnum numberTypeEnum,
                                               String trackingNumber, LocalDateTime creationTime) {
        return new PackageTrackingNumber(id, packageCode, numberTypeEnum, trackingNumber, creationTime);
    }
}
