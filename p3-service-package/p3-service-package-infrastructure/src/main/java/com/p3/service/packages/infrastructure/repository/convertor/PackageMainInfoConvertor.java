package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageServiceItem;
import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.infrastructure.repository.entity.PackageMainInfoEntity;
import com.p3.service.packages.infrastructure.repository.entity.PackageServiceItemEntity;
import com.p3.service.packages.infrastructure.repository.entity.PackageSpatialAttributeEntity;
import com.p3.service.packages.infrastructure.repository.entity.PackageTrackingNumberEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PackageMainInfoConvertor {

    public static PackageMainInfoEntity convertToDataEntity(PackageMainInfo mainInfo) {

        return mainInfo.mapWith((id, packageCode, trackingNumbers, attributes, serviceItems, customerCode, customerNickname, customerLevel, customerType, thirdPartyCustomerCode, thirdPartyCustomerLevel, shippingWarehouse, destinationCountry, primaryGoodsType, secondaryGoodsType, goodsValue, composited, shippingMethod) ->
                new PackageMainInfoEntity()
                        .setId(id)
                        .setPackageCode(packageCode)
                        .setCustomerCode(customerCode)
                        .setCustomerNickname(customerNickname)
                        .setCustomerLevel(customerLevel)
                        .setCustomerType(customerType)
                        .setThirdPartyCustomerCode(thirdPartyCustomerCode)
                        .setThirdPartyCustomerLevel(thirdPartyCustomerLevel)
                        .setShippingWarehouse(shippingWarehouse)
                        .setDestinationCountry(destinationCountry)
                        .setPrimaryGoodsType(primaryGoodsType)
                        .setSecondaryGoodsType(secondaryGoodsType)
                        .setGoodsValue(goodsValue)
                        .setComposited(composited)
                        .setShippingMethod(shippingMethod));
    }

    public static PackageMainInfo convertToDomainEntity(PackageMainInfoEntity entity, List<PackageTrackingNumberEntity> packageTrackingNumberEntities, List<PackageSpatialAttributeEntity> packageSpatialAttributeEntities, List<PackageServiceItemEntity> packageServiceItemEntities) {

        return new PackageMainInfo(entity.getId(), entity.getPackageCode(), Optional.ofNullable(packageTrackingNumberEntities).map(entities -> entities.stream().map(PackageMainInfoConvertor::convertToDomainEntity).collect(Collectors.toList())).orElse(null), Optional.ofNullable(packageSpatialAttributeEntities).map(entities -> entities.stream().map(PackageMainInfoConvertor::convertToDomainEntity).collect(Collectors.toList())).orElse(null), Optional.ofNullable(packageServiceItemEntities).map(entities -> entities.stream().map(PackageMainInfoConvertor::convertToDomainEntity).collect(Collectors.toList())).orElse(null), entity.getCustomerCode(), entity.getCustomerNickname(), entity.getCustomerLevel(), entity.getCustomerType(), entity.getThirdPartyCustomerCode(), entity.getThirdPartyCustomerLevel(), entity.getShippingWarehouse(), entity.getDestinationCountry(), entity.getPrimaryGoodsType(), entity.getSecondaryGoodsType(), entity.getGoodsValue(), entity.getComposited(), entity.getShippingMethod());
    }

    public static PackageTrackingNumber convertToDomainEntity(PackageTrackingNumberEntity packageTrackingNumberEntity) {
        return new PackageTrackingNumber(
                packageTrackingNumberEntity.getId(),
                packageTrackingNumberEntity.getPackageCode(),
                packageTrackingNumberEntity.getNumberType(),
                packageTrackingNumberEntity.getTrackingNumber(),
                packageTrackingNumberEntity.getCreationTime());
    }

    public static PackageSpatialAttribute convertToDomainEntity(PackageSpatialAttributeEntity packageSpatialAttributeEntity) {
        return new PackageSpatialAttribute(
                packageSpatialAttributeEntity.getId(),
                packageSpatialAttributeEntity.getPackageCode(),
                packageSpatialAttributeEntity.getLength(),
                packageSpatialAttributeEntity.getWidth(),
                packageSpatialAttributeEntity.getHeight(),
                packageSpatialAttributeEntity.getVolume(),
                packageSpatialAttributeEntity.getWeight(),
                packageSpatialAttributeEntity.getMeasurementTime());
    }

    public static PackageServiceItem convertToDomainEntity(PackageServiceItemEntity packageServiceItemEntity) {
        return new PackageServiceItem(
                packageServiceItemEntity.getId(),
                packageServiceItemEntity.getPackageCode(),
                packageServiceItemEntity.getServiceType(),
                packageServiceItemEntity.getServiceName(),
                packageServiceItemEntity.getFee(),
                packageServiceItemEntity.getActivated(),
                packageServiceItemEntity.getCreationTime());
    }
}
