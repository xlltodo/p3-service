package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.CompositePackageAssociation;
import com.p3.service.packages.domain.model.entity.CompositePackageMainInfo;
import com.p3.service.packages.domain.model.entity.CompositePackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumber;
import com.p3.service.packages.domain.model.factory.CompositePackageMainInfoFactory;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageAssociationEntity;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageMainInfoEntity;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageSpatialAttributeEntity;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageTrackingNumberEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompositePackageMainInfoConvertor {

    public static CompositePackageMainInfoEntity convertToDataEntity(CompositePackageMainInfo mainInfo) {
        return mainInfo.mapWith((id, compositePackageCode, compositeMethod, compositeQuantity, compositePackagingType, transportMethodCode, transportMethodName, primaryGoodsType, secondaryGoodsType, packageAssociations) ->
                new CompositePackageMainInfoEntity()
                        .setId(id)
                        .setCompositePackageCode(compositePackageCode)
                        .setCompositeMethod(compositeMethod)
                        .setCompositeQuantity(compositeQuantity)
                        .setCompositePackagingType(compositePackagingType)
                        .setTransportMethodCode(transportMethodCode)
                        .setTransportMethodName(transportMethodName)
                        .setPrimaryGoodsType(primaryGoodsType)
                        .setSecondaryGoodsType(secondaryGoodsType));
    }

    public static CompositePackageTrackingNumberEntity convertToTrackingNumberDataEntity(CompositePackageTrackingNumber domainEntity) {
        return domainEntity.mapWith((id, compositePackageCode, numberType, trackingNumber, creationTime) ->
                new CompositePackageTrackingNumberEntity()
                        .setId(id)
                        .setCompositePackageCode(compositePackageCode)
                        .setNumberType(numberType)
                        .setTrackingNumber(trackingNumber)
                        .setCreationTime(creationTime));
    }

    public static List<CompositePackageTrackingNumberEntity> convertToTrackingNumberDataEntities(List<CompositePackageTrackingNumber> domainEntities) {
        return Optional.ofNullable(domainEntities).map(list -> list.stream().map(CompositePackageMainInfoConvertor::convertToTrackingNumberDataEntity).collect(Collectors.toList())).orElse(null);
    }

    public static CompositePackageSpatialAttributeEntity convertToSpatialAttributeDataEntity(CompositePackageSpatialAttribute domainEntity) {
        return domainEntity.mapWith((id, compositePackageCode, length, width, height, volume, weight, measurementTime) ->
                new CompositePackageSpatialAttributeEntity()
                        .setId(id)
                        .setCompositePackageCode(compositePackageCode)
                        .setLength(length)
                        .setWeight(weight)
                        .setHeight(height)
                        .setVolume(volume)
                        .setWeight(weight)
                        .setMeasurementTime(measurementTime));
    }

    public static List<CompositePackageSpatialAttributeEntity> convertToSpatialAttributeDataEntities(List<CompositePackageSpatialAttribute> domainEntities) {
        return Optional.ofNullable(domainEntities).map(list -> list.stream().map(CompositePackageMainInfoConvertor::convertToSpatialAttributeDataEntity).collect(Collectors.toList())).orElse(null);
    }

    public static CompositePackageAssociationEntity convertToAssociationDataEntity(CompositePackageAssociation domainEntity) {
        return domainEntity.mapWith((id, compositePackageCode, packageCode) ->
                new CompositePackageAssociationEntity()
                        .setId(id)
                        .setCompositePackageCode(compositePackageCode)
                        .setPackageCode(packageCode));
    }

    public static List<CompositePackageAssociationEntity> convertToAssociationDataEntities(List<CompositePackageAssociation> domainEntities) {
        return Optional.ofNullable(domainEntities).map(list -> list.stream().map(CompositePackageMainInfoConvertor::convertToAssociationDataEntity).collect(Collectors.toList())).orElse(null);
    }

    public static CompositePackageMainInfo convertToDomainEntity(CompositePackageMainInfoEntity entity) {
        return CompositePackageMainInfoFactory.create(
                entity.getId(),
                entity.getCompositePackageCode(),
                entity.getCompositeMethod(),
                entity.getCompositeQuantity(),
                entity.getCompositePackagingType(),
                entity.getTransportMethodCode(),
                entity.getTransportMethodName(),
                entity.getPrimaryGoodsType(),
                entity.getSecondaryGoodsType(),
                null,
                null,
                null
        );
    }
}
