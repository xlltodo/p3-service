package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;
import com.p3.service.packages.infrastructure.repository.entity.PackageTrackingNumberEntity;

public class PackageTrackingNumberConvertor {

    public static PackageTrackingNumberEntity convertToDataEntity(PackageTrackingNumber packageTrackingNumber) {
        return packageTrackingNumber.mapWith((id, packageCode, numberType, trackingNumber, creationTime) ->
                new PackageTrackingNumberEntity()
                        .setId(id)
                        .setPackageCode(packageCode)
                        .setNumberType(numberType.toString()) // 转换枚举为字符串
                        .setTrackingNumber(trackingNumber)
                        .setCreationTime(creationTime));
    }

    public static PackageTrackingNumber convertToDomainEntity(PackageTrackingNumberEntity entity) {
        return new PackageTrackingNumber(
                entity.getId(),
                entity.getPackageCode(),
                PackageTrackingNumberTypeEnum.valueOf(entity.getNumberType()),
                entity.getTrackingNumber(),
                entity.getCreationTime());
    }
}
