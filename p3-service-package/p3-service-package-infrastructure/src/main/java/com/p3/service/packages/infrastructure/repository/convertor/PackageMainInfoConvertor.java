package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.*;
import com.p3.service.packages.infrastructure.repository.entity.*;

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

    public static PackageTrackingNumberEntity convertToDataEntity(PackageTrackingNumber packageTrackingNumber) {
        return packageTrackingNumber.mapWith((id, packageCode, numberType, trackingNumber, creationTime) -> new PackageTrackingNumberEntity()
                .setId(id)
                .setPackageCode(packageCode)
                .setNumberType(numberType.getCode())
                .setTrackingNumber(trackingNumber)
                .setCreationTime(creationTime));
    }

    public static List<PackageTrackingNumberEntity> convertToPackageTrackingNumberDataEntities(List<PackageTrackingNumber> packageTrackingNumbers) {
        return Optional.ofNullable(packageTrackingNumbers).map(list -> list.stream().map(PackageMainInfoConvertor::convertToDataEntity).collect(Collectors.toList())).orElse(null);
    }

    public static PackageServiceItemEntity convertToDataEntity(PackageServiceItem packageServiceItem) {
        return packageServiceItem.mapWith((id, packageCode, serviceType, serviceName, fee, activated, creationTime) -> new PackageServiceItemEntity()
                .setId(id)
                .setPackageCode(packageCode)
                .setServiceType(serviceType)
                .setServiceName(serviceName)
                .setFee(fee)
                .setActivated(activated)
                .setCreationTime(creationTime));
    }

    public static List<PackageServiceItemEntity> convertToPackageServiceItemDataEntities(List<PackageServiceItem> packageServiceItems) {
        return Optional.ofNullable(packageServiceItems).map(list -> list.stream().map(PackageMainInfoConvertor::convertToDataEntity).collect(Collectors.toList())).orElse(null);
    }

    public static PackageGoodsInfoEntity convertToDataEntity(PackageGoodsInfo packageGoodsInfo) {
        return packageGoodsInfo.mapWith((id, packageCode, productName, goodsName, goodsType, specification, shipmentQuantity, unitPrice, totalPrice, imageUrl) -> new PackageGoodsInfoEntity()
                .setId(id)
                .setPackageCode(packageCode)
                .setProductName(productName)
                .setGoodsName(goodsName)
                .setGoodsType(goodsType)
                .setSpecification(specification)
                .setUnitPrice(unitPrice)
                .setTotalPrice(totalPrice)
                .setImageUrl(imageUrl));
    }

    public static List<PackageGoodsInfoEntity> convertToPackageGoodsInfoDataEntities(List<PackageGoodsInfo> packageGoodsInfos) {
        return Optional.ofNullable(packageGoodsInfos).map(list -> list.stream().map(PackageMainInfoConvertor::convertToDataEntity).collect(Collectors.toList())).orElse(null);
    }

    public static PackageSpatialAttributeEntity convertToDataEntity(PackageSpatialAttribute packageSpatialAttribute) {
        return packageSpatialAttribute.mapWith((id, packageCode, length, width, height, volume, weight, measurementTime) -> new PackageSpatialAttributeEntity()
                .setId(id)
                .setPackageCode(packageCode)
                .setLength(length)
                .setWeight(weight)
                .setHeight(height)
                .setVolume(volume)
                .setMeasurementTime(measurementTime));
    }

    public static List<PackageSpatialAttributeEntity> convertToPackageSpatialAttributeDataEntities(List<PackageSpatialAttribute> packageSpatialAttributes) {
        return Optional.ofNullable(packageSpatialAttributes).map(list -> list.stream().map(PackageMainInfoConvertor::convertToDataEntity).collect(Collectors.toList())).orElse(null);
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
