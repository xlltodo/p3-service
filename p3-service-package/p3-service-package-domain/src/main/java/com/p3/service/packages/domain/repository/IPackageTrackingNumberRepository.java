package com.p3.service.packages.domain.repository;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;

public interface IPackageTrackingNumberRepository {

    Boolean addTrackingNumber(PackageTrackingNumber packageTrackingNumber);
}
