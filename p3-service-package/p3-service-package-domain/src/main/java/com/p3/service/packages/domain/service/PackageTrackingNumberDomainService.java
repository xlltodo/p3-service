package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PackageTrackingNumberDomainService {



    public static PackageTrackingNumber create(String id, String packageCode, String numberType,
                                               String trackingNumber, LocalDateTime creationTime) {
        return new PackageTrackingNumber(id, packageCode, numberType, trackingNumber, creationTime);
    }
}
