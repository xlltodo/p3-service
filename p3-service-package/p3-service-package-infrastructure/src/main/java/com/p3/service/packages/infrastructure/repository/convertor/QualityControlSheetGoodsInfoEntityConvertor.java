package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetGoodsInfoEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QualityControlSheetGoodsInfoEntityConvertor {

    public static QualityControlSheetGoodsInfoEntity convertToDataEntity(QualityControlSheetGoodsInfo goodsInfo) {
        return goodsInfo.mapWith((id, sheetId, productName, goodsName, goodsType, specification, shipmentQuantity, unitPrice, totalPrice, imageUrl) ->
                new QualityControlSheetGoodsInfoEntity()
                        .setId(id)
                        .setSheetId(sheetId)
                        .setProductName(productName)
                        .setGoodsName(goodsName)
                        .setGoodsType(goodsType)
                        .setSpecification(specification)
                        .setShipmentQuantity(shipmentQuantity)
                        .setUnitPrice(unitPrice)
                        .setTotalPrice(totalPrice)
                        .setImageUrl(imageUrl));
    }

    public static QualityControlSheetGoodsInfo convertToDomainEntity(QualityControlSheetGoodsInfoEntity entity) {
        return new QualityControlSheetGoodsInfo(
                entity.getId(),
                entity.getSheetId(),
                entity.getProductName(),
                entity.getGoodsName(),
                entity.getGoodsType(),
                entity.getSpecification(),
                entity.getShipmentQuantity(),
                entity.getUnitPrice(),
                entity.getTotalPrice(),
                entity.getImageUrl());
    }

    public static List<QualityControlSheetGoodsInfo> convertToDomainEntities(List<QualityControlSheetGoodsInfoEntity> goodsInfoEntities) {
        return Optional.ofNullable(goodsInfoEntities).map(entities -> entities.stream().map(QualityControlSheetGoodsInfoEntityConvertor::convertToDomainEntity).collect(Collectors.toList())).orElse(null);
    }
}
