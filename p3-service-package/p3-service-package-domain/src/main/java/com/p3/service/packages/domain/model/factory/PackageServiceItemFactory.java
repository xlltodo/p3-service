package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageServiceItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PackageServiceItemFactory {

    public static PackageServiceItem create(String id, String packageCode, String serviceType, String serviceName, BigDecimal fee, Integer activated, LocalDateTime creationTime) {
        return new PackageServiceItem(id, packageCode, serviceType, serviceName, fee, activated, creationTime);
    }
}
