package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetPackageEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QualityControlSheetPackageEntityConvertor {

    public static QualityControlSheetPackageEntity convertToDataEntity(QualityControlSheetPackage packageEntity) {
        return packageEntity.mapWith((id, sheetId, weight, length, width, height, volume, quantity, productName, brandName, primaryGoodsType, secondaryGoodsType) ->
                new QualityControlSheetPackageEntity()
                        .setId(id)
                        .setSheetId(sheetId)
                        .setWeight(weight)
                        .setLength(length)
                        .setWidth(width)
                        .setHeight(height)
                        .setVolume(volume)
                        .setQuantity(quantity)
                        .setProductName(productName)
                        .setBrandName(brandName)
                        .setPrimaryGoodsType(primaryGoodsType)
                        .setSecondaryGoodsType(secondaryGoodsType));
    }

    public static QualityControlSheetPackage convertToDomainEntity(QualityControlSheetPackageEntity entity) {
        return new QualityControlSheetPackage(
                entity.getId(),
                entity.getSheetId(),
                entity.getWeight(),
                entity.getLength(),
                entity.getWidth(),
                entity.getHeight(),
                entity.getVolume(),
                entity.getQuantity(),
                entity.getProductName(),
                entity.getBrandName(),
                entity.getPrimaryGoodsType(),
                entity.getSecondaryGoodsType());
    }

    public static List<QualityControlSheetPackage> convertToDomainEntities(List<QualityControlSheetPackageEntity> packageEntities) {
        return Optional.ofNullable(packageEntities).map(entities -> entities.stream().map(QualityControlSheetPackageEntityConvertor::convertToDomainEntity).collect(Collectors.toList())).orElse(null);
    }
}
