package com.p3.service.packages.domain.service.common;

import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumberTypeEnum;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;

public interface IIdentityGenerator {

    String generateSnowflakeId();

    String generatePackageTrackingNumber(PackageTrackingNumberTypeEnum trackingNumberTypeEnum);

    String generateCompositePackageTrackingNumber(CompositePackageTrackingNumberTypeEnum trackingNumberTypeEnum);
}
